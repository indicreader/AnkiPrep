package com.example.flashcardapp.data.scraper

import android.content.Context
import com.example.flashcardapp.data.ImageStorageManager
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

/**
 * Heuristic parser for generic educational quiz websites (Sanfoundry, Examveda, GeeksforGeeks, etc.).
 */
object GenericMcqScraper : SiteScraper {

    override fun canHandle(url: String): Boolean = true

    override fun scrape(url: String, html: String, context: Context): ScrapeResult {
        val doc = Jsoup.parse(html, url)
        val cards = mutableListOf<ScrapedCard>()

        val pageTitle = doc.title().ifBlank { doc.select("h1").firstOrNull()?.text() ?: "Web Quiz Deck" }
            .replace(Regex("""(?i)\b(quiz|mcqs|questions|answers|indiabix|sanfoundry|examveda)\b"""), "")
            .trim()
            .ifEmpty { "Web Quiz Deck" }

        // Find potential MCQ blocks using common selectors or headings
        val blocks = doc.select(".question-block, .mcq-container, article, .entry-content, .post-content, body")

        for (block in blocks) {
            val qElems = block.select("h3, h4, p:matches(^\\d+[\\.\\)]\\s+)")
            for (qElem in qElems) {
                try {
                    val rawQ = qElem.text().replace(Regex("""^\d+[\.\)]\s+"""), "").trim()
                    if (rawQ.length < 5) continue

                    val qImgSrc = qElem.select("img").firstOrNull()?.absUrl("src")
                    val frontImg = if (!qImgSrc.isNullOrBlank()) ImageStorageManager.downloadImageFromUrl(context, qImgSrc) else null

                    // Look for options in subsequent list items or sibling divs
                    var nextElem: Element? = qElem.nextElementSibling()
                    val options = mutableListOf<String>()
                    val optionImgPaths = mutableListOf<String?>()
                    var explanation = ""
                    var answerText = ""

                    while (nextElem != null && !nextElem.tagName().matches(Regex("h[1-4]"))) {
                        val text = nextElem.text().trim()
                        if (nextElem.tagName() in listOf("ul", "ol")) {
                            for (li in nextElem.select("li")) {
                                val optText = li.text().replace(Regex("""^[a-eA-E][\.\)]\s+"""), "").trim()
                                val optImgSrc = li.select("img").firstOrNull()?.absUrl("src")
                                val optImgPath = if (!optImgSrc.isNullOrBlank()) ImageStorageManager.downloadImageFromUrl(context, optImgSrc) else null

                                if (optText.isNotEmpty() || optImgPath != null) {
                                    options.add(optText.ifEmpty { "Option Image" })
                                    optionImgPaths.add(optImgPath)
                                }
                            }
                        } else if (text.startsWith("Answer:", ignoreCase = true) || text.startsWith("Correct Answer:", ignoreCase = true)) {
                            answerText = text.substringAfter(":").trim()
                        } else if (text.startsWith("Explanation:", ignoreCase = true) || text.startsWith("Solution:", ignoreCase = true)) {
                            explanation = text.substringAfter(":").trim()
                        }
                        nextElem = nextElem.nextElementSibling()
                    }

                    if (options.size >= 2) {
                        val finalAnswer = if (answerText.isNotEmpty()) {
                            options.firstOrNull { it.contains(answerText, ignoreCase = true) } ?: answerText
                        } else {
                            options.first()
                        }

                        val optImgJson = if (optionImgPaths.any { it != null }) {
                            com.google.gson.Gson().toJson(optionImgPaths.map { it ?: "" })
                        } else null

                        cards.add(
                            ScrapedCard(
                                question = rawQ,
                                answer = finalAnswer,
                                options = options,
                                explanation = explanation.ifEmpty { "The correct answer is: $finalAnswer" },
                                frontImage = frontImg,
                                optionImagesJson = optImgJson,
                                tags = listOf("web_scrape"),
                                sourceUrl = url
                            )
                        )
                    }
                } catch (_: Exception) {}
            }
            if (cards.isNotEmpty()) break
        }

        val nextPageElem = doc.select("a[rel=next], a:contains(Next Page), a.next").firstOrNull()
        val nextPageUrl = nextPageElem?.absUrl("href")?.takeIf { it.isNotBlank() && it != url }

        return ScrapeResult(
            cards = cards,
            nextPageUrl = nextPageUrl,
            topicTitle = pageTitle
        )
    }
}
