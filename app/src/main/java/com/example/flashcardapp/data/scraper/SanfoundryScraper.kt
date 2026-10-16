package com.example.flashcardapp.data.scraper

import android.content.Context
import com.example.flashcardapp.data.ImageStorageManager
import org.jsoup.Jsoup

/**
 * Scraper for Sanfoundry & Examveda technical MCQs.
 */
object SanfoundryScraper : SiteScraper {

    override fun canHandle(url: String): Boolean {
        val lower = url.lowercase()
        return lower.contains("sanfoundry.com") || lower.contains("examveda.com")
    }

    override fun scrape(url: String, html: String, context: Context): ScrapeResult {
        val doc = Jsoup.parse(html, url)
        val cards = mutableListOf<ScrapedCard>()

        val pageTitle = doc.select("h1.entry-title, .page-header-title, h1").firstOrNull()?.text()
            ?.replace("Questions and Answers", "")
            ?.trim()
            ?.ifEmpty { "Sanfoundry Quiz" } ?: "Sanfoundry Quiz"

        val qElems = doc.select(".entry-content p:matches(^\\d+[\\.\\)]\\s+), .question-content")

        for (qElem in qElems) {
            try {
                val rawQ = qElem.text().replace(Regex("""^\d+[\.\)]\s+"""), "").trim()
                if (rawQ.length < 5) continue

                val qImgSrc = qElem.select("img").firstOrNull()?.absUrl("src")
                val frontImg = if (!qImgSrc.isNullOrBlank()) ImageStorageManager.downloadImageFromUrl(context, qImgSrc) else null

                // Collapse options inside collapsible answer block
                val options = mutableListOf<String>()
                val optionImgPaths = mutableListOf<String?>()
                var answerText = ""
                var explanation = ""

                var nextElem = qElem.nextElementSibling()
                while (nextElem != null && !nextElem.tagName().matches(Regex("h[1-4]|p:matches(^\\d+[\\.\\)])"))) {
                    val text = nextElem.text().trim()
                    if (text.startsWith("a)") || text.startsWith("b)") || text.startsWith("c)") || text.startsWith("d)")) {
                        val lines = text.split("\n").map { it.trim() }
                        for (line in lines) {
                            val optText = line.replace(Regex("""^[a-eA-E][\.\)]\s+"""), "").trim()
                            val optImgSrc = nextElem.select("img").firstOrNull()?.absUrl("src")
                            val optImgPath = if (!optImgSrc.isNullOrBlank()) ImageStorageManager.downloadImageFromUrl(context, optImgSrc) else null
                            if (optText.isNotEmpty() || optImgPath != null) {
                                options.add(optText.ifEmpty { "Option Image" })
                                optionImgPaths.add(optImgPath)
                            }
                        }
                    } else if (nextElem.hasClass("collapseanswer") || text.contains("View Answer")) {
                        val ansText = nextElem.select(".collapseanswer, div").text().trim()
                        val match = Regex("""(?i)Answer:\s*([a-eA-E])""").find(ansText)
                        if (match != null) {
                            answerText = match.groupValues[1].uppercase()
                        }
                        if (ansText.contains("Explanation:")) {
                            explanation = ansText.substringAfter("Explanation:").trim()
                        }
                    }
                    nextElem = nextElem.nextElementSibling()
                }

                if (options.isNotEmpty()) {
                    var correctIdx = when (answerText) {
                        "A" -> 0; "B" -> 1; "C" -> 2; "D" -> 3; "E" -> 4; else -> 0
                    }
                    val finalAnswer = options.getOrElse(correctIdx) { options.first() }

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
                            tags = listOf("sanfoundry", pageTitle.lowercase().replace(" ", "_")),
                            sourceUrl = url
                        )
                    )
                }
            } catch (_: Exception) {}
        }

        val nextPageElem = doc.select("a[rel=next], .nav-previous a, a:contains(Next)").firstOrNull()
        val nextPageUrl = nextPageElem?.absUrl("href")?.takeIf { it.isNotBlank() && it != url }

        return ScrapeResult(
            cards = cards,
            nextPageUrl = nextPageUrl,
            topicTitle = pageTitle
        )
    }
}
