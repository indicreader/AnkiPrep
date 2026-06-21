package com.example.flashcardapp.mcq

/**
 * Utility to classify flashcard questions and answers into semantic categories.
 * 
 * Supported categories:
 * - person: names, titles, historical figures
 * - year/date: years, dates, centuries, decades
 * - place: locations, countries, cities, geographic features
 * - law/article: constitutional articles, sections, amendments, physical laws, equations
 * - number: quantities, ratios, percentages, counts
 * - concept: general terms, definitions, abstract concepts (default fallback)
 */
object SemanticClassifier {

    private val dateRegex = """\b\d{1,2}[-/. ]([A-Za-z]+|\d{1,2})[-/. ]\d{2,4}\b""".toRegex()
    private val pureYearRegex = """\b(?:1\d{3}|20\d{2}|[1-9]\d{2})\b(?:\s*(?:B\.?C\.?|A\.?D\.?|B\.?C\.?E\.?|C\.?E\.?))?""".toRegex()
    private val numberRegex = """\b[-+]?\s*(?:\d{1,3}(?:,\d{3})*|\d+)(?:\.\d+)?\s*%?\b""".toRegex()
    private val currencyRegex = """[$€£¥]\s*[-+]?\s*(?:\d{1,3}(?:,\d{3})*|\d+)(?:\.\d+)?\b""".toRegex()
    private val wordNumberRegex = """\b\d+\s*(?:million|billion|trillion|percent|meters|metres|km|miles|kg|lbs|degrees|hours|days|years|old)\b""".toRegex()
    private val nameRegex = """^[A-Z][a-zA-Z]+(?:\s+[A-Z][a-zA-Z]+){1,2}$""".toRegex()
    private val nameRegexWithInitials = """^[A-Z][a-zA-Z]*(?:\s+[A-Z]\.)?\s+[A-Z][a-zA-Z]+$""".toRegex()

    fun classify(question: String, answer: String): String {
        val q = question.trim().lowercase()
        val a = answer.trim()
        val aLower = a.lowercase()

        // 1. Check for year/date
        if (isYearOrDate(q, a, aLower)) {
            return "year/date"
        }

        // 2. Check for law/article
        if (isLawOrArticle(q, a, aLower)) {
            return "law/article"
        }

        // 3. Check for number
        if (isNumber(q, a, aLower)) {
            return "number"
        }

        // 4. Check for person
        if (isPerson(q, a, aLower)) {
            return "person"
        }

        // 5. Check for place
        if (isPlace(q, a, aLower)) {
            return "place"
        }

        // 6. Default to concept
        return "concept"
    }

    private fun isYearOrDate(q: String, a: String, aLower: String): Boolean {
        // e.g. "1994", "2023", "500 BC", "4th century BC", "in 1994", "around 2023"
        val monthNames = listOf(
            "january", "february", "march", "april", "may", "june",
            "july", "august", "september", "october", "november", "december",
            "jan", "feb", "mar", "apr", "jun", "jul", "aug", "sep", "oct", "nov", "dec"
        )
        val hasMonth = monthNames.any { aLower.contains(it) }
        val hasDigits = aLower.any { it.isDigit() }

        // Question keywords indicating a date/year
        val dateQuestionKeywords = listOf(
            "when", "what year", "which year", "what date", "which date",
            "founded in", "established in", "born in", "died in", "published in"
        )

        return dateRegex.containsMatchIn(a) ||
               pureYearRegex.matches(a) ||
               (hasMonth && hasDigits) ||
               aLower.contains("century") ||
               aLower.contains("decade") ||
               dateQuestionKeywords.any { q.contains(it) }
    }

    private fun isLawOrArticle(q: String, a: String, aLower: String): Boolean {
        // e.g., "Article 21", "Section 144", "First Amendment", "Newton's First Law", "V = IR"
        val lawKeywords = listOf(
            "article", "section", "amendment", "law", "act", "bill", "treaty",
            "clause", "statute", "code", "doctrine", "theorem", "principle", "postulate"
        )
        
        // Also match common formulas or short definitions of laws
        val isFormula = aLower.contains("=") && (aLower.contains("v") || aLower.contains("i") || aLower.contains("r") || aLower.contains("f") || aLower.contains("m") || aLower.contains("a"))
        
        return lawKeywords.any { aLower.contains(it) } ||
               lawKeywords.any { q.contains(it) } ||
               isFormula ||
               aLower.contains("amendment")
    }

    private fun isNumber(q: String, a: String, aLower: String): Boolean {
        val numQuestionKeywords = listOf(
            "how many", "how much", "percentage of", "what percent", "what number", "quantity", "count"
        )
        // BUG FIX: use containsMatchIn() instead of matches() — matches() requires the ENTIRE string
        // to satisfy the regex including word-boundary anchors \b, which fails for short pure-number strings.
        // We additionally require the match spans the full trimmed string to avoid false positives.
        val trimmedA = a.trim()
        val numberFullMatch = numberRegex.find(trimmedA)?.let { it.value.trim() == trimmedA } == true
        val currencyFullMatch = currencyRegex.find(trimmedA)?.let { it.value.trim() == trimmedA } == true

        return numberFullMatch ||
               currencyFullMatch ||
               wordNumberRegex.containsMatchIn(aLower) ||
               numQuestionKeywords.any { q.contains(it) }
    }

    private fun isPerson(q: String, a: String, aLower: String): Boolean {
        // Starts with title or matches name formats
        val titles = listOf(
            "mr", "mrs", "ms", "dr", "prof", "sir", "president", "king",
            "queen", "emperor", "pope", "lord", "lady", "saint", "st"
        )
        val startsWithTitle = titles.any { aLower.startsWith("$it ") || aLower.startsWith("$it.") }

        val personQuestionKeywords = listOf(
            "who is", "who was", "whose", "who wrote", "who painted",
            "who discovered", "who invented", "written by", "discovered by",
            "invented by", "led by", "ruled by", "founded by", "authored by",
            "directed by"
        )

        return startsWithTitle ||
               nameRegex.matches(a) ||
               nameRegexWithInitials.matches(a) ||
               personQuestionKeywords.any { q.contains(it) }
    }

    private fun isPlace(q: String, a: String, aLower: String): Boolean {
        // Suffixes, prepositions
        val placePrepositions = listOf("in ", "at ", "to ", "from ")
        val startsWithPlacePreposition = placePrepositions.any { aLower.startsWith(it) } && a.substringAfter(" ").firstOrNull()?.isUpperCase() == true
        
        val placeKeywords = listOf(
            "city", "state", "country", "capital", "mountain", "ocean", "sea",
            "lake", "river", "continent", "island", "desert", "valley", "republic",
            "kingdom", "nation", "location", "headquarters"
        )
        val hasPlaceKeyword = placeKeywords.any { aLower.contains(it) }
        
        val famousPlaces = listOf(
            "usa", "uk", "america", "london", "paris", "tokyo", "rome", "india",
            "china", "japan", "germany", "france", "italy", "spain", "canada",
            "brazil", "russia", "australia", "africa", "asia", "europe",
            "antarctica", "egypt", "washington", "new york", "beijing", "moscow",
            "berlin", "delhi", "mumbai"
        )
        val isFamousPlace = famousPlaces.any { aLower.contains(it) }

        val placeQuestionKeywords = listOf(
            "where ", "location of", "located in", "situated in", "capital of",
            "which country", "which city", "which state"
        )

        return startsWithPlacePreposition ||
               hasPlaceKeyword ||
               isFamousPlace ||
               placeQuestionKeywords.any { q.contains(it) }
    }
}
