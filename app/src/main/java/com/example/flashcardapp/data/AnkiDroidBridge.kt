package com.example.flashcardapp.data

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log

/**
 * Represents a raw deck fetched from the AnkiDroid content provider. The [name] may contain '::'
 * hierarchy separators.
 */
data class AnkiDeck(val id: Long, val name: String)

/**
 * Represents a raw flashcard fetched from AnkiDroid. Includes [tags] extracted from the notes
 * table.
 */
data class AnkiFlashcard(
        val cardId: Long,
        val noteId: Long,
        val front: String,
        val back: String,
        val tags: List<String> = emptyList()
)

/**
 * Read-only bridge to the AnkiDroid content provider.
 *
 * Queries decks, cards, and notes via the standard AnkiDroid API content URIs. All access is
 * read-only — we never write to AnkiDroid's database.
 *
 * Content provider columns reference:
 * - Decks: _id, name
 * - Cards: _id, note_id, deck_id
 * - Notes: _id, flds (fields separated by \u001f), tags (space-separated)
 */
object AnkiDroidBridge {
    private const val TAG = "AnkiDroidBridge"
    private const val AUTHORITY = "com.ichi2.anki.providers.info"

    val DECKS_URI: Uri = Uri.parse("content://$AUTHORITY/decks")
    val CARDS_URI: Uri = Uri.parse("content://$AUTHORITY/cards")
    val NOTES_URI: Uri = Uri.parse("content://$AUTHORITY/notes")

    const val PERMISSION = "com.ichi2.anki.permission.READ_WRITE_DATABASE"
    const val PACKAGE_NAME = "com.ichi2.anki"

    fun isAnkiDroidInstalled(context: Context): Boolean {
        return try {
            context.packageManager.getPackageInfo(PACKAGE_NAME, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    fun hasPermission(context: Context): Boolean {
        return context.checkSelfPermission(PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Fetches all decks from AnkiDroid.
     *
     * Returns mock data when AnkiDroid is not installed or permission is missing, allowing
     * development/testing without a real AnkiDroid installation.
     */
    fun getDecks(context: Context): List<AnkiDeck> {
        if (!isAnkiDroidInstalled(context) || !hasPermission(context)) {
            Log.w(TAG, "AnkiDroid not available, returning mock decks")
            return getMockDecks()
        }

        val list = mutableListOf<AnkiDeck>()
        try {
            context.contentResolver.query(DECKS_URI, arrayOf("_id", "name"), null, null, null)
                    ?.use { cursor ->
                        val idCol = cursor.getColumnIndex("_id")
                        val nameCol = cursor.getColumnIndex("name")
                        if (idCol >= 0 && nameCol >= 0) {
                            while (cursor.moveToNext()) {
                                val id = cursor.getLong(idCol)
                                val name = cursor.getString(nameCol) ?: ""
                                list.add(AnkiDeck(id, name))
                            }
                        }
                    }
            Log.d(TAG, "Loaded ${list.size} decks from AnkiDroid")
        } catch (e: Exception) {
            Log.e(TAG, "Error querying decks from AnkiDroid", e)
        }
        return list
    }

    /**
     * Fetches all cards for a given deck, including tag data from the notes table.
     *
     * This performs a two-pass query:
     * 1. Query cards table → get card IDs and note IDs for the deck
     * 2. Query notes table → get field content and tags for each note
     * 3. Join and normalize into [AnkiFlashcard] objects
     */
    fun getCardsAndNotesForDeck(context: Context, deckId: Long): List<AnkiFlashcard> {
        val cardsList = mutableListOf<AnkiFlashcard>()
        if (!hasPermission(context)) {
            Log.w(TAG, "No permission, returning mock cards for deck $deckId")
            return getMockCardsForDeck(deckId)
        }

        val cardIds = mutableListOf<Long>()
        val noteIds = mutableListOf<Long>()

        // Pass 1: Query all cards in the selected deck to get card_id and note_id
        try {
            context.contentResolver.query(
                            CARDS_URI,
                            arrayOf("_id", "note_id", "deck_id"),
                            "deck_id = ?",
                            arrayOf(deckId.toString()),
                            null
                    )
                    ?.use { cursor ->
                        val idCol = cursor.getColumnIndex("_id")
                        val noteIdCol = cursor.getColumnIndex("note_id")
                        if (idCol >= 0 && noteIdCol >= 0) {
                            while (cursor.moveToNext()) {
                                cardIds.add(cursor.getLong(idCol))
                                noteIds.add(cursor.getLong(noteIdCol))
                            }
                        }
                    }
        } catch (e: Exception) {
            Log.e(TAG, "Error querying cards for deck $deckId", e)
            return cardsList
        }

        if (noteIds.isEmpty()) {
            Log.d(TAG, "No cards found for deck $deckId")
            return cardsList
        }

        // Pass 2: Query notes for field content and tags
        data class NoteData(val fields: String, val tags: String)
        val notesMap = mutableMapOf<Long, NoteData>()
        try {
            noteIds.distinct().chunked(500).forEach { chunk ->
                val placeholders = chunk.joinToString(",") { "?" }
                val selection = "_id IN ($placeholders)"
                val selectionArgs = chunk.map { it.toString() }.toTypedArray()

                context.contentResolver.query(
                                NOTES_URI,
                                arrayOf("_id", "flds", "tags"),
                                selection,
                                selectionArgs,
                                null
                        )
                        ?.use { cursor ->
                            val idCol = cursor.getColumnIndex("_id")
                            val fldsCol = cursor.getColumnIndex("flds")
                            val tagsCol = cursor.getColumnIndex("tags")
                            if (idCol >= 0 && fldsCol >= 0) {
                                while (cursor.moveToNext()) {
                                    val id = cursor.getLong(idCol)
                                    val flds = cursor.getString(fldsCol) ?: ""
                                    val tags =
                                            if (tagsCol >= 0) cursor.getString(tagsCol) ?: ""
                                            else ""
                                    notesMap[id] = NoteData(flds, tags)
                                }
                            }
                        }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error querying notes for deck $deckId", e)
        }

        // Pass 3: Combine cards and notes, stripping HTML, parsing tags
        for (i in cardIds.indices) {
            val cardId = cardIds[i]
            val noteId = noteIds[i]
            val noteData = notesMap[noteId] ?: continue
            val fields = noteData.fields.split("\u001f")

            val rawFront = fields.getOrNull(0) ?: ""
            val rawBack = fields.getOrNull(1) ?: ""

            val front = stripHtml(rawFront)
            val back = stripHtml(rawBack)

            // Parse space-separated tags from AnkiDroid
            val tags = noteData.tags.split(" ").map { it.trim() }.filter { it.isNotEmpty() }

            if (front.isNotEmpty() && back.isNotEmpty()) {
                cardsList.add(AnkiFlashcard(cardId, noteId, front, back, tags))
            }
        }

        Log.d(
                TAG,
                "Loaded ${cardsList.size} cards for deck $deckId (${cardsList.count { it.tags.isNotEmpty() }} have tags)"
        )
        return cardsList
    }

    /**
     * Parses the AnkiDroid deck hierarchy from a full deck name.
     * Delegates to [DeckHierarchyUtils] for pure Kotlin implementation.
     */
    fun parseDeckHierarchy(deckName: String): List<String> =
        DeckHierarchyUtils.parseDeckHierarchy(deckName)

    /**
     * Extracts the leaf deck name from a hierarchical path.
     * Delegates to [DeckHierarchyUtils].
     */
    fun getLeafDeckName(deckName: String): String =
        DeckHierarchyUtils.getLeafDeckName(deckName)

    /**
     * Determines the parent deck path from a hierarchical name.
     * Delegates to [DeckHierarchyUtils].
     */
    fun getParentDeckPath(deckName: String): String? =
        DeckHierarchyUtils.getParentDeckPath(deckName)

    private fun stripHtml(html: String): String =
        DeckHierarchyUtils.stripHtml(html)

    // ========================================================================
    // Mock Data — Used when AnkiDroid is not installed (dev/testing)
    // ========================================================================

    private fun getMockDecks(): List<AnkiDeck> {
        return listOf(
                AnkiDeck(1001, "General Knowledge & Trivia"),
                AnkiDeck(1002, "Kotlin & Jetpack Compose"),
                AnkiDeck(1003, "World Geography"),
                AnkiDeck(1004, "Science::Biology::Genetics"),
                AnkiDeck(1005, "Science::Biology::Ecology"),
                AnkiDeck(1006, "Science::Physics")
        )
    }

    private fun getMockCardsForDeck(deckId: Long): List<AnkiFlashcard> {
        val mockCards =
                mapOf(
                        1001L to
                                listOf(
                                        AnkiFlashcard(
                                                101,
                                                201,
                                                "What is the capital of France?",
                                                "Paris",
                                                listOf("geography", "europe")
                                        ),
                                        AnkiFlashcard(
                                                102,
                                                202,
                                                "What year did World War II end?",
                                                "1945",
                                                listOf("history", "war")
                                        ),
                                        AnkiFlashcard(
                                                103,
                                                203,
                                                "What is the chemical symbol for water?",
                                                "H₂O",
                                                listOf("chemistry")
                                        ),
                                        AnkiFlashcard(
                                                104,
                                                204,
                                                "Who painted the Mona Lisa?",
                                                "Leonardo da Vinci",
                                                listOf("art", "renaissance")
                                        ),
                                        AnkiFlashcard(
                                                105,
                                                205,
                                                "What is the largest planet in our solar system?",
                                                "Jupiter",
                                                listOf("astronomy")
                                        ),
                                        AnkiFlashcard(
                                                106,
                                                206,
                                                "What is the speed of light?",
                                                "299,792,458 m/s",
                                                listOf("physics")
                                        ),
                                        AnkiFlashcard(
                                                107,
                                                207,
                                                "Who wrote Romeo and Juliet?",
                                                "William Shakespeare",
                                                listOf("literature")
                                        ),
                                        AnkiFlashcard(
                                                108,
                                                208,
                                                "What is the smallest prime number?",
                                                "2",
                                                listOf("math")
                                        ),
                                        AnkiFlashcard(
                                                109,
                                                209,
                                                "What is the currency of Japan?",
                                                "Yen",
                                                listOf("geography", "asia")
                                        ),
                                        AnkiFlashcard(
                                                110,
                                                210,
                                                "What element has atomic number 1?",
                                                "Hydrogen",
                                                listOf("chemistry")
                                        ),
                                        AnkiFlashcard(
                                                111,
                                                211,
                                                "What is the tallest mountain on Earth?",
                                                "Mount Everest",
                                                listOf("geography")
                                        ),
                                        AnkiFlashcard(
                                                112,
                                                212,
                                                "Who discovered penicillin?",
                                                "Alexander Fleming",
                                                listOf("medicine", "history")
                                        )
                                ),
                        1002L to
                                listOf(
                                        AnkiFlashcard(
                                                201,
                                                301,
                                                "What keyword declares an immutable variable in Kotlin?",
                                                "val",
                                                listOf("kotlin", "basics")
                                        ),
                                        AnkiFlashcard(
                                                202,
                                                302,
                                                "What is a data class in Kotlin?",
                                                "A class that automatically generates equals(), hashCode(), toString(), copy()",
                                                listOf("kotlin", "classes")
                                        ),
                                        AnkiFlashcard(
                                                203,
                                                303,
                                                "What is a Composable function?",
                                                "A function annotated with @Composable that defines UI elements",
                                                listOf("compose", "ui")
                                        ),
                                        AnkiFlashcard(
                                                204,
                                                304,
                                                "What is remember in Jetpack Compose?",
                                                "A composable function that stores a single object in memory across recompositions",
                                                listOf("compose", "state")
                                        ),
                                        AnkiFlashcard(
                                                205,
                                                305,
                                                "What is LaunchedEffect?",
                                                "A side-effect handler that runs a suspend function when entering the composition",
                                                listOf("compose", "effects")
                                        ),
                                        AnkiFlashcard(
                                                206,
                                                306,
                                                "What is a coroutine?",
                                                "A concurrency design pattern for asynchronous programming in Kotlin",
                                                listOf("kotlin", "coroutines")
                                        ),
                                        AnkiFlashcard(
                                                207,
                                                307,
                                                "What does 'suspend' keyword do?",
                                                "Marks a function that can be paused and resumed, usable only in coroutines",
                                                listOf("kotlin", "coroutines")
                                        ),
                                        AnkiFlashcard(
                                                208,
                                                308,
                                                "What is StateFlow?",
                                                "A hot observable state holder that emits updates to collectors",
                                                listOf("kotlin", "flow")
                                        ),
                                        AnkiFlashcard(
                                                209,
                                                309,
                                                "What is Room?",
                                                "An abstraction layer over SQLite for local database persistence",
                                                listOf("android", "database")
                                        ),
                                        AnkiFlashcard(
                                                210,
                                                310,
                                                "What is MVVM?",
                                                "Model-View-ViewModel architecture pattern separating UI from business logic",
                                                listOf("architecture")
                                        ),
                                        AnkiFlashcard(
                                                211,
                                                311,
                                                "What is Hilt?",
                                                "A dependency injection library for Android built on Dagger",
                                                listOf("android", "di")
                                        ),
                                        AnkiFlashcard(
                                                212,
                                                312,
                                                "What is Navigation Compose?",
                                                "Jetpack library for handling navigation between composable screens",
                                                listOf("compose", "navigation")
                                        )
                                ),
                        1003L to
                                listOf(
                                        AnkiFlashcard(
                                                301,
                                                401,
                                                "What is the largest continent by area?",
                                                "Asia",
                                                listOf("continents")
                                        ),
                                        AnkiFlashcard(
                                                302,
                                                402,
                                                "What is the longest river in the world?",
                                                "Nile",
                                                listOf("rivers")
                                        ),
                                        AnkiFlashcard(
                                                303,
                                                403,
                                                "What country has the largest population?",
                                                "India",
                                                listOf("demographics")
                                        ),
                                        AnkiFlashcard(
                                                304,
                                                404,
                                                "What is the smallest country in the world?",
                                                "Vatican City",
                                                listOf("countries")
                                        ),
                                        AnkiFlashcard(
                                                305,
                                                405,
                                                "What ocean is the largest?",
                                                "Pacific Ocean",
                                                listOf("oceans")
                                        ),
                                        AnkiFlashcard(
                                                306,
                                                406,
                                                "What desert is the largest?",
                                                "Sahara Desert",
                                                listOf("deserts")
                                        ),
                                        AnkiFlashcard(
                                                307,
                                                407,
                                                "What is the capital of Australia?",
                                                "Canberra",
                                                listOf("capitals", "oceania")
                                        ),
                                        AnkiFlashcard(
                                                308,
                                                408,
                                                "How many time zones does Russia span?",
                                                "11",
                                                listOf("countries", "facts")
                                        ),
                                        AnkiFlashcard(
                                                309,
                                                409,
                                                "What mountain range separates Europe from Asia?",
                                                "Ural Mountains",
                                                listOf("mountains")
                                        ),
                                        AnkiFlashcard(
                                                310,
                                                410,
                                                "What is the deepest ocean trench?",
                                                "Mariana Trench",
                                                listOf("oceans")
                                        )
                                ),
                        1004L to
                                listOf(
                                        AnkiFlashcard(
                                                401,
                                                501,
                                                "What is DNA?",
                                                "Deoxyribonucleic acid — carries genetic instructions",
                                                listOf("genetics", "molecular")
                                        ),
                                        AnkiFlashcard(
                                                402,
                                                502,
                                                "What are alleles?",
                                                "Different versions of the same gene",
                                                listOf("genetics")
                                        ),
                                        AnkiFlashcard(
                                                403,
                                                503,
                                                "What is a phenotype?",
                                                "The observable characteristics of an organism",
                                                listOf("genetics")
                                        ),
                                        AnkiFlashcard(
                                                404,
                                                504,
                                                "What is a genotype?",
                                                "The genetic makeup of an organism",
                                                listOf("genetics")
                                        ),
                                        AnkiFlashcard(
                                                405,
                                                505,
                                                "What is crossing over?",
                                                "Exchange of genetic material between homologous chromosomes during meiosis",
                                                listOf("genetics", "meiosis")
                                        ),
                                        AnkiFlashcard(
                                                406,
                                                506,
                                                "What is a dominant allele?",
                                                "An allele that expresses its phenotype even in heterozygous form",
                                                listOf("genetics")
                                        ),
                                        AnkiFlashcard(
                                                407,
                                                507,
                                                "What is Mendel's law of segregation?",
                                                "Each organism has two alleles for each trait, and they separate during gamete formation",
                                                listOf("genetics", "mendel")
                                        ),
                                        AnkiFlashcard(
                                                408,
                                                508,
                                                "What is a mutation?",
                                                "A change in the DNA sequence",
                                                listOf("genetics", "molecular")
                                        ),
                                        AnkiFlashcard(
                                                409,
                                                509,
                                                "What is PCR?",
                                                "Polymerase Chain Reaction — amplifies DNA segments",
                                                listOf("genetics", "techniques")
                                        ),
                                        AnkiFlashcard(
                                                410,
                                                510,
                                                "What is CRISPR?",
                                                "A gene editing tool that allows precise modifications to DNA",
                                                listOf("genetics", "techniques")
                                        )
                                ),
                        1005L to
                                listOf(
                                        AnkiFlashcard(
                                                501,
                                                601,
                                                "What is an ecosystem?",
                                                "A community of organisms and their physical environment",
                                                listOf("ecology", "basics")
                                        ),
                                        AnkiFlashcard(
                                                502,
                                                602,
                                                "What is a food chain?",
                                                "A linear pathway showing energy transfer between organisms",
                                                listOf("ecology", "energy")
                                        ),
                                        AnkiFlashcard(
                                                503,
                                                603,
                                                "What is biodiversity?",
                                                "The variety of life in a particular habitat or ecosystem",
                                                listOf("ecology")
                                        ),
                                        AnkiFlashcard(
                                                504,
                                                604,
                                                "What is symbiosis?",
                                                "A close ecological relationship between two or more species",
                                                listOf("ecology", "relationships")
                                        ),
                                        AnkiFlashcard(
                                                505,
                                                605,
                                                "What is a keystone species?",
                                                "A species that has a disproportionately large effect on its ecosystem",
                                                listOf("ecology")
                                        ),
                                        AnkiFlashcard(
                                                506,
                                                606,
                                                "What is carrying capacity?",
                                                "The maximum population size an environment can sustainably support",
                                                listOf("ecology", "population")
                                        ),
                                        AnkiFlashcard(
                                                507,
                                                607,
                                                "What is primary succession?",
                                                "Ecological succession that occurs in lifeless areas with no soil",
                                                listOf("ecology", "succession")
                                        ),
                                        AnkiFlashcard(
                                                508,
                                                608,
                                                "What is the carbon cycle?",
                                                "The biogeochemical cycle of carbon through Earth's systems",
                                                listOf("ecology", "cycles")
                                        ),
                                        AnkiFlashcard(
                                                509,
                                                609,
                                                "What is eutrophication?",
                                                "Excessive nutrient enrichment in water bodies causing algal blooms",
                                                listOf("ecology", "pollution")
                                        ),
                                        AnkiFlashcard(
                                                510,
                                                610,
                                                "What is a trophic level?",
                                                "A position in a food chain occupied by organisms",
                                                listOf("ecology", "energy")
                                        )
                                ),
                        1006L to
                                listOf(
                                        AnkiFlashcard(
                                                601,
                                                701,
                                                "What is Newton's first law?",
                                                "An object at rest stays at rest unless acted upon by a force",
                                                listOf("physics", "mechanics")
                                        ),
                                        AnkiFlashcard(
                                                602,
                                                702,
                                                "What is F = ma?",
                                                "Newton's second law: Force equals mass times acceleration",
                                                listOf("physics", "mechanics")
                                        ),
                                        AnkiFlashcard(
                                                603,
                                                703,
                                                "What is kinetic energy?",
                                                "Energy of motion: KE = ½mv²",
                                                listOf("physics", "energy")
                                        ),
                                        AnkiFlashcard(
                                                604,
                                                704,
                                                "What is Ohm's law?",
                                                "V = IR — voltage equals current times resistance",
                                                listOf("physics", "electricity")
                                        ),
                                        AnkiFlashcard(
                                                605,
                                                705,
                                                "What is the wavelength?",
                                                "The distance between consecutive crests of a wave",
                                                listOf("physics", "waves")
                                        ),
                                        AnkiFlashcard(
                                                606,
                                                706,
                                                "What is entropy?",
                                                "A measure of disorder in a system",
                                                listOf("physics", "thermodynamics")
                                        ),
                                        AnkiFlashcard(
                                                607,
                                                707,
                                                "What is a photon?",
                                                "A quantum of electromagnetic radiation",
                                                listOf("physics", "quantum")
                                        ),
                                        AnkiFlashcard(
                                                608,
                                                708,
                                                "What is momentum?",
                                                "Product of mass and velocity: p = mv",
                                                listOf("physics", "mechanics")
                                        ),
                                        AnkiFlashcard(
                                                609,
                                                709,
                                                "What is Boyle's law?",
                                                "At constant temperature, pressure and volume are inversely proportional",
                                                listOf("physics", "gas-laws")
                                        ),
                                        AnkiFlashcard(
                                                610,
                                                710,
                                                "What is refraction?",
                                                "Bending of light when passing between media of different densities",
                                                listOf("physics", "optics")
                                        )
                                )
                )
        return mockCards[deckId] ?: emptyList()
    }
}
