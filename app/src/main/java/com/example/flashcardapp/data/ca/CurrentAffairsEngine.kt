package com.example.flashcardapp.data.ca

import android.util.Xml
import com.example.flashcardapp.data.entities.CurrentAffairsSourceEntity
import com.example.flashcardapp.data.entities.QuestionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xmlpull.v1.XmlPullParser
import java.io.StringReader
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.UUID
import java.util.concurrent.TimeUnit

data class FeedItem(
    val title: String,
    val description: String,
    val pubDate: String
)

object CurrentAffairsEngine {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    /**
     * Fetches XML feed from [sourceUrl], parses RSS/Atom items, and synthesizes MCQ [QuestionEntity] list.
     */
    suspend fun fetchAndSynthesizeMCQs(
        source: CurrentAffairsSourceEntity,
        existingTitles: Set<String>
    ): Result<List<QuestionEntity>> = withContext(Dispatchers.IO) {
        runCatching {
            val request = Request.Builder()
                .url(source.feedUrl)
                .header("User-Agent", "AnkiPrep-Android-CAEngine/1.0")
                .build()

            val response = okHttpClient.newCall(request).execute()
            if (!response.isSuccessful) {
                throw IllegalStateException("HTTP ${response.code} fetching feed: ${source.title}")
            }

            val xmlContent = response.body?.string()
                ?: throw IllegalStateException("Empty body received from ${source.title}")

            val feedItems = parseXmlItems(xmlContent)
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val todayDateStr = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(Date())

            val synthesizedQuestions = mutableListOf<QuestionEntity>()

            feedItems.forEach { item ->
                val cleanTitle = cleanHtml(item.title).trim()
                if (cleanTitle.length < 10) return@forEach

                // Deduplication check
                val normalizedTitleKey = cleanTitle.lowercase(Locale.ROOT).replace(Regex("[^a-z0-9]"), "")
                if (existingTitles.contains(normalizedTitleKey)) {
                    return@forEach
                }

                val cleanDesc = cleanHtml(item.description).trim().ifBlank { cleanTitle }
                val subTopic = classifySubTopic(cleanTitle + " " + cleanDesc)
                val summaryOptionA = truncateSummary(cleanDesc, fallback = cleanTitle)

                val questionText = "With reference to recent developments, consider the following headline: '$cleanTitle'. Which of the following statements is correct?"

                val entity = QuestionEntity(
                    id = UUID.randomUUID().toString(),
                    questionText = questionText,
                    optionA = summaryOptionA,
                    optionB = "The initiative was deferred pending further regulatory committee review.",
                    optionC = "The development applies exclusively to private foreign commercial entities.",
                    optionD = "None of the above statements are accurate.",
                    correctAnswer = "A",
                    explanation = cleanDesc.take(400) + "\n\nSource: ${source.title}",
                    subject = "Current Affairs",
                    subTopic = subTopic,
                    examName = "Daily Current Affairs",
                    examYear = currentYear,
                    examRawTag = "[Daily CA $todayDateStr]"
                )
                synthesizedQuestions.add(entity)
            }

            synthesizedQuestions
        }
    }

    /**
     * Native XmlPullParser for RSS (<item>) and Atom (<entry>) feeds.
     */
    private fun parseXmlItems(xmlContent: String): List<FeedItem> {
        val items = mutableListOf<FeedItem>()
        try {
            val parser = Xml.newPullParser()
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(StringReader(xmlContent))

            var eventType = parser.eventType
            var currentTitle = ""
            var currentDesc = ""
            var currentPubDate = ""
            var insideItem = false

            while (eventType != XmlPullParser.END_DOCUMENT) {
                val name = parser.name
                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        if (name.equals("item", ignoreCase = true) || name.equals("entry", ignoreCase = true)) {
                            insideItem = true
                            currentTitle = ""
                            currentDesc = ""
                            currentPubDate = ""
                        } else if (insideItem) {
                            when (name.lowercase(Locale.ROOT)) {
                                "title" -> currentTitle = parser.nextText()
                                "description", "summary", "content" -> currentDesc = parser.nextText()
                                "pubdate", "published", "updated" -> currentPubDate = parser.nextText()
                            }
                        }
                    }
                    XmlPullParser.END_TAG -> {
                        if (name.equals("item", ignoreCase = true) || name.equals("entry", ignoreCase = true)) {
                            insideItem = false
                            if (currentTitle.isNotBlank()) {
                                items.add(FeedItem(currentTitle, currentDesc, currentPubDate))
                            }
                        }
                    }
                }
                eventType = parser.next()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Regex fallback if XmlPullParser hits malformed XML
            return parseXmlItemsRegexFallback(xmlContent)
        }
        return items
    }

    private fun parseXmlItemsRegexFallback(xmlContent: String): List<FeedItem> {
        val items = mutableListOf<FeedItem>()
        val itemRegex = Regex("<(?:item|entry)[^>]*>([\\s\\S]*?)</(?:item|entry)>", RegexOption.IGNORE_CASE)
        val titleRegex = Regex("<title[^>]*>(?:<!\\[CDATA\\[)?([\\s\\S]*?)(?:\\]\\]>)?</title>", RegexOption.IGNORE_CASE)
        val descRegex = Regex("<(?:description|summary|content)[^>]*>(?:<!\\[CDATA\\[)?([\\s\\S]*?)(?:\\]\\]>)?</(?:description|summary|content)>", RegexOption.IGNORE_CASE)

        itemRegex.findAll(xmlContent).forEach { match ->
            val block = match.groupValues[1]
            val title = titleRegex.find(block)?.groupValues?.get(1)?.trim() ?: ""
            val desc = descRegex.find(block)?.groupValues?.get(1)?.trim() ?: ""
            if (title.isNotBlank()) {
                items.add(FeedItem(title, desc, ""))
            }
        }
        return items
    }

    /**
     * Classifies sub_topic based on headline & body keywords.
     */
    private fun classifySubTopic(text: String): String {
        val lower = text.lowercase(Locale.ROOT)
        return when {
            Regex("\\b(rbi|gdp|bank|inflation|stock|tariff|export|import|rupee|market|tax|budget|finance|imf|economy)\\b").containsMatchIn(lower) ->
                "Economy & Banking"
            Regex("\\b(isro|nasa|satellite|ai|technology|space|quantum|biotech|cyber|drone|semiconductor|robot|vaccine|science)\\b").containsMatchIn(lower) ->
                "Science & Technology"
            Regex("\\b(cricket|olympic|tournament|champion|cup|tennis|gold medal|fifa|athletics|medal|match|sports)\\b").containsMatchIn(lower) ->
                "Sports & Games"
            Regex("\\b(treaty|summit|un|nato|president|prime minister|bilateral|embassy|ambassador|g20|brics|agreement|border|diplomacy)\\b").containsMatchIn(lower) ->
                "International Relations"
            else ->
                "National Events"
        }
    }

    private fun cleanHtml(html: String): String {
        return html.replace(Regex("<[^>]*>"), " ")
            .replace("&nbsp;", " ")
            .replace("&amp;", "&")
            .replace("&quot;", "\"")
            .replace("&#39;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace(Regex("\\s+"), " ")
            .trim()
    }

    private fun truncateSummary(text: String, fallback: String): String {
        val clean = cleanHtml(text)
        if (clean.length in 15..200) return clean
        if (clean.length > 200) return clean.take(197) + "..."
        return fallback.take(200)
    }
}
