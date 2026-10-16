package com.example.flashcardapp.data.scraper

import android.content.Context
import com.example.flashcardapp.data.ImageStorageManager
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.net.URI

/**
 * Dedicated Jsoup scraper for IndiaBIX (Aptitude, Reasoning, GK, CS, Engineering).
 */
object IndiaBixScraper : SiteScraper {

    override fun canHandle(url: String): Boolean {
        return url.lowercase().contains("indiabix.com")
    }

    override fun scrape(url: String, html: String, context: Context): ScrapeResult {
        val doc = Jsoup.parse(html, url)
        val cards = mutableListOf<ScrapedCard>()

        // Topic Title
        val topicTitle = doc.select(".main-left h1, h1, .page-header-title").firstOrNull()?.text()
            ?.replace("General Knowledge - ", "")
            ?.replace("Aptitude - ", "")
            ?.trim()
            ?.ifEmpty { "IndiaBIX Quiz" }
            ?: "IndiaBIX Quiz"

        val topicTag = topicTitle.lowercase().replace(Regex("[^a-z0-9]"), "_").trim()

        // Question Containers
        val qContainers = doc.select(".bix-div-container, .bix-inner-card, .bix-tbl-container")

        for (container in qContainers) {
            try {
                // 1. Question Text & Image
                val qTxtElem = container.select(".bix-td-qtxt, .bix-qtxt").firstOrNull() ?: continue
                val rawQTxt = qTxtElem.text().trim()
                if (rawQTxt.isBlank()) continue

                val qImgSrc = qTxtElem.select("img").firstOrNull()?.absUrl("src")
                val frontImage = if (!qImgSrc.isNullOrBlank()) {
                    ImageStorageManager.downloadImageFromUrl(context, qImgSrc)
                } else null

                // 2. Options Extraction
                val optionRows = container.select(".bix-td-option, .bix-opt-row, .bix-tbl-options tr")
                val optionTexts = mutableListOf<String>()
                val optionImagePaths = mutableListOf<String?>()

                for (row in optionRows) {
                    val optValElem = row.select(".bix-td-option-val, td:nth-child(2)").firstOrNull() ?: row
                    val optText = optValElem.text().trim()

                    val optImgSrc = optValElem.select("img").firstOrNull()?.absUrl("src")
                    val optImgPath = if (!optImgSrc.isNullOrBlank()) {
                        ImageStorageManager.downloadImageFromUrl(context, optImgSrc)
                    } else null

                    if (optText.isNotEmpty() || optImgPath != null) {
                        optionTexts.add(optText.ifEmpty { "Option Image" })
                        optionImagePaths.add(optImgPath)
                    }
                }

                if (optionTexts.isEmpty()) continue

                // 3. Answer Extraction
                val ansInputVal = container.select(".jq-has-answer, input[name^=answer], .bix-ans-option").firstOrNull()?.let { elem ->
                    if (elem.tagName() == "input") elem.attr("value") else elem.text()
                }?.trim()?.uppercase() ?: ""

                var correctIdx = 0
                when (ansInputVal) {
                    "A", "1" -> correctIdx = 0
                    "B", "2" -> correctIdx = 1
                    "C", "3" -> correctIdx = 2
                    "D", "4" -> correctIdx = 3
                    "E", "5" -> correctIdx = 4
                    else -> {
                        // Try matching answer text if given as option string
                        val idx = optionTexts.indexOfFirst { it.equals(ansInputVal, ignoreCase = true) }
                        if (idx != -1) correctIdx = idx
                    }
                }

                val correctAnswerText = optionTexts.getOrElse(correctIdx) { optionTexts.first() }

                // 4. Explanation Extraction
                val explElem = container.select(".bix-ans-description, .bix-div-answer, .bix-ans-option-val").firstOrNull()
                val explText = explElem?.text()?.trim() ?: "The correct answer is: $correctAnswerText"

                val explImgSrc = explElem?.select("img")?.firstOrNull()?.absUrl("src")
                val explanationImage = if (!explImgSrc.isNullOrBlank()) {
                    ImageStorageManager.downloadImageFromUrl(context, explImgSrc)
                } else null

                val optionImagesJson = if (optionImagePaths.any { it != null }) {
                    com.google.gson.Gson().toJson(optionImagePaths.map { it ?: "" })
                } else null

                cards.add(
                    ScrapedCard(
                        question = rawQTxt,
                        answer = correctAnswerText,
                        options = optionTexts,
                        explanation = explText,
                        frontImage = frontImage,
                        optionImagesJson = optionImagesJson,
                        explanationImage = explanationImage,
                        tags = listOf("indiabix", topicTag).filter { it.isNotBlank() },
                        sourceUrl = url
                    )
                )
            } catch (_: Exception) {
                // Ignore broken container
            }
        }

        // 5. Next Page Link
        val nextPageElem = doc.select("a.page-link[rel=next], .mx-pager-next a, a:contains(Next)").firstOrNull()
        val nextPageUrl = nextPageElem?.absUrl("href")?.takeIf { it.isNotBlank() && it != url }

        return ScrapeResult(
            cards = cards,
            nextPageUrl = nextPageUrl,
            topicTitle = topicTitle
        )
    }
}
