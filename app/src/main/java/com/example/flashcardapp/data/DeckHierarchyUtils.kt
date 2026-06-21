package com.example.flashcardapp.data

/**
 * Pure Kotlin utility functions for deck hierarchy parsing.
 *
 * These are extracted from [AnkiDroidBridge] to allow unit testing
 * without Android dependencies (Uri, ContentResolver, etc.).
 */
object DeckHierarchyUtils {

    /**
     * Parses the AnkiDroid deck hierarchy from a full deck name.
     *
     * AnkiDroid uses '::' as a hierarchy separator.
     * Example: "Science::Biology::Genetics" → ["Science", "Biology", "Genetics"]
     *
     * @return List of hierarchy segments from root to leaf
     */
    fun parseDeckHierarchy(deckName: String): List<String> {
        return deckName.split("::")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }

    /**
     * Extracts the leaf deck name from a hierarchical path.
     *
     * Example: "Science::Biology::Genetics" → "Genetics"
     */
    fun getLeafDeckName(deckName: String): String {
        return parseDeckHierarchy(deckName).lastOrNull() ?: deckName
    }

    /**
     * Determines the parent deck path from a hierarchical name.
     *
     * Example: "Science::Biology::Genetics" → "Science::Biology"
     * Example: "Science" → null (root deck)
     */
    fun getParentDeckPath(deckName: String): String? {
        val segments = parseDeckHierarchy(deckName)
        return if (segments.size > 1) {
            segments.dropLast(1).joinToString("::")
        } else {
            null
        }
    }

    /**
     * Strips HTML tags from a string, converting <br> to newlines
     * and decoding common HTML entities.
     */
    fun stripHtml(html: String): String {
        var text = html.replace(Regex("(?i)<br\\s*/?>"), "\n")
        text = text.replace(Regex("<[^>]*>"), "")
        text = text.replace("&nbsp;", " ")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&amp;", "&")
            .replace("&quot;", "\"")
            .replace("&apos;", "'")

        // Decode hex entities: &#x[0-9a-fA-F]+;
        text = text.replace(Regex("(?i)&#x([0-9a-f]+);")) { matchResult ->
            val hexVal = matchResult.groupValues[1]
            try {
                hexVal.toInt(16).toChar().toString()
            } catch (e: Exception) {
                matchResult.value
            }
        }
        // Decode decimal entities: &#[0-9]+;
        text = text.replace(Regex("&#([0-9]+);")) { matchResult ->
            val decVal = matchResult.groupValues[1]
            try {
                decVal.toInt().toChar().toString()
            } catch (e: Exception) {
                matchResult.value
            }
        }
        return text.trim()
    }
}
