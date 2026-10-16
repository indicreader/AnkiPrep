package com.example.flashcardapp.data.scraper

import android.content.Context
import com.example.flashcardapp.data.ImageStorageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

/**
 * Data model for an MCQ card extracted from a website.
 */
data class ScrapedCard(
    val question: String,
    val answer: String,
    val options: List<String>,
    val explanation: String = "",
    val frontImage: String? = null,
    val optionImagesJson: String? = null,
    val explanationImage: String? = null,
    val tags: List<String> = emptyList(),
    val sourceUrl: String = ""
)

/**
 * Result of scraping a single web page.
 */
data class ScrapeResult(
    val cards: List<ScrapedCard>,
    val nextPageUrl: String? = null,
    val topicTitle: String = "Scraped Deck",
    val error: String? = null
)

/**
 * Interface for website-specific HTML parsers.
 */
interface SiteScraper {
    fun canHandle(url: String): Boolean
    fun scrape(url: String, html: String, context: Context): ScrapeResult
}

/**
 * Manager for web scraping MCQs from IndiaBIX and educational quiz websites.
 */
object WebScraperEngine {
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    private val scrapers: List<SiteScraper> = listOf(
        IndiaBixScraper,
        SanfoundryScraper,
        GenericMcqScraper
    )

    /**
     * Fetches a web page URL and parses MCQs using the appropriate scraper.
     */
    suspend fun scrapeUrl(context: Context, url: String): ScrapeResult = withContext(Dispatchers.IO) {
        val trimmedUrl = url.trim()
        if (trimmedUrl.isEmpty()) return@withContext ScrapeResult(emptyList(), error = "URL cannot be empty")

        try {
            val request = Request.Builder()
                .url(trimmedUrl)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.9")
                .build()

            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                return@withContext ScrapeResult(emptyList(), error = "HTTP ${response.code}: ${response.message}")
            }

            val html = response.body?.string() ?: ""
            if (html.isBlank()) {
                return@withContext ScrapeResult(emptyList(), error = "Empty HTML response from page")
            }

            // Check if user has a custom rule for this domain
            val customRules = CustomScraperManager.getRules(context)
            val matchedRule = customRules.firstOrNull { trimmedUrl.lowercase().contains(it.domain.lowercase()) }

            if (matchedRule != null) {
                val doc = org.jsoup.Jsoup.parse(html, trimmedUrl)
                val cards = mutableListOf<ScrapedCard>()
                val qElements = doc.select(matchedRule.questionSelector)
                for (qElem in qElements) {
                    try {
                        val qText = qElem.text().trim()
                        if (qText.isEmpty()) continue
                        val opts = doc.select(matchedRule.optionSelector).map { it.text().trim() }.filter { it.isNotEmpty() }
                        val ans = doc.select(matchedRule.answerSelector).firstOrNull()?.text()?.trim() ?: opts.firstOrNull() ?: ""
                        val expl = doc.select(matchedRule.explanationSelector).firstOrNull()?.text()?.trim() ?: ""

                        if (opts.isNotEmpty()) {
                            cards.add(
                                ScrapedCard(
                                    question = qText,
                                    answer = ans,
                                    options = opts,
                                    explanation = expl,
                                    tags = listOf("custom_scrape", matchedRule.name.lowercase().replace(" ", "_")),
                                    sourceUrl = trimmedUrl
                                )
                            )
                        }
                    } catch (_: Exception) {}
                }
                val nextUrl = doc.select(matchedRule.nextSelector).firstOrNull()?.absUrl("href")?.takeIf { it.isNotBlank() && it != trimmedUrl }
                if (cards.isNotEmpty()) {
                    return@withContext ScrapeResult(cards, nextUrl, matchedRule.name)
                }
            }

            val activeScraper = scrapers.firstOrNull { it.canHandle(trimmedUrl) } ?: GenericMcqScraper
            return@withContext activeScraper.scrape(trimmedUrl, html, context)
        } catch (e: Exception) {
            ScrapeResult(emptyList(), error = "Failed to scrape page: ${e.localizedMessage}")
        }
    }
}
