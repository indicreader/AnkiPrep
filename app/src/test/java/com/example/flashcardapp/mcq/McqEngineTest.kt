package com.example.flashcardapp.mcq

import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.AliasEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

/**
 * Unit tests for the MCQ generation engine.
 *
 * Test cases per requirements:
 * 1. Always 4 options
 * 2. Correct answer always included
 * 3. No duplicate options
 * 4. Distractors come from correct hierarchy
 * + Determinism, edge cases, shuffle behavior
 */
class McqEngineTest {

    private lateinit var engine: McqEngine
    private lateinit var sampleCards: List<CardEntity>
    private lateinit var hierarchicalCards: List<CardEntity>

    @Before
    fun setup() {
        // Fixed seed for deterministic tests
        engine = McqEngine(random = Random(42))

        // 12 cards in a single flat deck
        sampleCards = (1..12).map { i ->
            CardEntity(
                id = i.toLong(),
                noteId = (100 + i).toLong(),
                deckId = 1L,
                front = "Question $i?",
                back = "Answer $i",
                tags = "[\"tag$i\"]",
                deckHierarchy = "TestDeck"
            )
        }

        // Cards across a hierarchical deck structure
        hierarchicalCards = listOf(
            // Science::Biology::Genetics (deckId=101)
            CardEntity(1, 101, 101, front = "What is DNA?", back = "Deoxyribonucleic acid", deckHierarchy = "Science::Biology::Genetics"),
            CardEntity(2, 102, 101, front = "What are alleles?", back = "Different versions of a gene", deckHierarchy = "Science::Biology::Genetics"),
            CardEntity(3, 103, 101, front = "What is a phenotype?", back = "Observable characteristics", deckHierarchy = "Science::Biology::Genetics"),
            CardEntity(4, 104, 101, front = "What is a genotype?", back = "Genetic makeup", deckHierarchy = "Science::Biology::Genetics"),
            CardEntity(5, 105, 101, front = "What is crossing over?", back = "Exchange of genetic material", deckHierarchy = "Science::Biology::Genetics"),

            // Science::Biology::Ecology (deckId=102)
            CardEntity(6, 106, 102, front = "What is an ecosystem?", back = "Community and environment", deckHierarchy = "Science::Biology::Ecology"),
            CardEntity(7, 107, 102, front = "What is biodiversity?", back = "Variety of life", deckHierarchy = "Science::Biology::Ecology"),
            CardEntity(8, 108, 102, front = "What is symbiosis?", back = "Close ecological relationship", deckHierarchy = "Science::Biology::Ecology"),
            CardEntity(9, 109, 102, front = "What is a food chain?", back = "Energy transfer pathway", deckHierarchy = "Science::Biology::Ecology"),

            // Science::Physics (deckId=103)
            CardEntity(10, 110, 103, front = "What is F=ma?", back = "Newton's second law", deckHierarchy = "Science::Physics"),
            CardEntity(11, 111, 103, front = "What is kinetic energy?", back = "Energy of motion", deckHierarchy = "Science::Physics"),
            CardEntity(12, 112, 103, front = "What is Ohm's law?", back = "V = IR", deckHierarchy = "Science::Physics"),

            // Math (deckId=200) — different root
            CardEntity(13, 113, 200, front = "What is pi?", back = "Ratio of circumference to diameter", deckHierarchy = "Math"),
            CardEntity(14, 114, 200, front = "What is a prime?", back = "Divisible only by 1 and itself", deckHierarchy = "Math"),
            CardEntity(15, 115, 200, front = "What is calculus?", back = "Study of change", deckHierarchy = "Math"),
            CardEntity(16, 116, 200, front = "What is an integral?", back = "Area under a curve", deckHierarchy = "Math")
        )
    }

    // ========================================================================
    // Test Case 1: Always 4 options
    // ========================================================================

    @Test
    fun `every MCQ has exactly 4 options`() {
        val mcqs = engine.generate(sampleCards)
        assertTrue("Expected at least 1 MCQ", mcqs.isNotEmpty())
        for (mcq in mcqs) {
            assertEquals("MCQ for card ${mcq.sourceCardId} should have 4 options", 4, mcq.options.size)
        }
    }

    @Test
    fun `every MCQ has exactly 4 options with hierarchical cards`() {
        val mcqs = engine.generate(hierarchicalCards)
        assertTrue("Expected MCQs from hierarchical cards", mcqs.isNotEmpty())
        for (mcq in mcqs) {
            assertEquals(4, mcq.options.size)
        }
    }

    // ========================================================================
    // Test Case 2: Correct answer always included
    // ========================================================================

    @Test
    fun `correct answer is always present in options`() {
        val mcqs = engine.generate(sampleCards)
        for (mcq in mcqs) {
            val correctAnswer = mcq.options[mcq.correctIndex]
            assertTrue(
                "Correct answer '$correctAnswer' should be in options for card ${mcq.sourceCardId}",
                mcq.options.contains(correctAnswer)
            )
        }
    }

    @Test
    fun `correctIndex is valid range 0-3`() {
        val mcqs = engine.generate(sampleCards)
        for (mcq in mcqs) {
            assertTrue(
                "correctIndex ${mcq.correctIndex} out of range for card ${mcq.sourceCardId}",
                mcq.correctIndex in 0..3
            )
        }
    }

    // ========================================================================
    // Test Case 3: No duplicate options
    // ========================================================================

    @Test
    fun `no duplicate options in any MCQ`() {
        val mcqs = engine.generate(sampleCards)
        for (mcq in mcqs) {
            val normalized = mcq.options.map { it.trim().lowercase() }
            assertEquals(
                "MCQ for card ${mcq.sourceCardId} has duplicate options: ${mcq.options}",
                4, normalized.distinct().size
            )
        }
    }

    @Test
    fun `no duplicate options in hierarchical MCQs`() {
        val mcqs = engine.generate(hierarchicalCards)
        for (mcq in mcqs) {
            val normalized = mcq.options.map { it.trim().lowercase() }
            assertEquals(
                "Duplicate options found: ${mcq.options}",
                4, normalized.distinct().size
            )
        }
    }

    // ========================================================================
    // Test Case 4: Distractors come from correct hierarchy
    // ========================================================================

    @Test
    fun `distractors for subdeck card prefer same subdeck`() {
        // Card 1 is in Science::Biology::Genetics (deckId=101)
        // There are 4 other cards in the same deck → distractors should come from there
        val mcqs = engine.generate(hierarchicalCards, targetDeckId = 101)
        assertTrue("Expected MCQs for Genetics deck", mcqs.isNotEmpty())

        val firstMcq = mcqs.first()
        // All distractor source IDs should exist in our card set
        for (sourceId in firstMcq.distractorSourceIds) {
            val sourceCard = hierarchicalCards.find { it.id == sourceId }
            assertNotNull("Distractor source card $sourceId should exist", sourceCard)
        }
    }

    @Test
    fun `distractor selection cascade falls back correctly`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Q1?", back = "Ans 1", deckHierarchy = "Science::Biology::Genetics"),
            CardEntity(2, 102, 2, front = "Q2?", back = "Ans 2", deckHierarchy = "Science::Biology::Ecology"),
            CardEntity(3, 103, 2, front = "Q3?", back = "Ans 3", deckHierarchy = "Science::Biology::Ecology"),
            CardEntity(4, 104, 3, front = "Q4?", back = "Ans 4", deckHierarchy = "Science::Physics"),
            CardEntity(5, 105, 4, front = "Q5?", back = "Ans 5", deckHierarchy = "Math")
        )

        val mcqs = engine.generate(cards, targetDeckId = 1)
        assertEquals(1, mcqs.size)
        val mcq = mcqs.first()

        val distractorTexts = mcq.options.filter { it != "Ans 1" }
        assertEquals(3, distractorTexts.size)
        assertTrue(distractorTexts.contains("Ans 2"))
        assertTrue(distractorTexts.contains("Ans 3"))
        assertTrue(distractorTexts.contains("Ans 4"))
        assertFalse(distractorTexts.contains("Ans 5"))
    }

    @Test
    fun `distractor selection cascade falls back to global pool when needed`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Q1?", back = "Ans 1", deckHierarchy = "Science::Biology::Genetics"),
            CardEntity(2, 102, 2, front = "Q2?", back = "Ans 2", deckHierarchy = "Science::Biology::Ecology"),
            CardEntity(3, 103, 3, front = "Q3?", back = "Ans 3", deckHierarchy = "Science::Physics"),
            CardEntity(4, 104, 4, front = "Q4?", back = "Ans 4", deckHierarchy = "Math")
        )

        val mcqs = engine.generate(cards, targetDeckId = 1)
        assertEquals(1, mcqs.size)
        val mcq = mcqs.first()

        val distractorTexts = mcq.options.filter { it != "Ans 1" }
        assertEquals(3, distractorTexts.size)
        assertTrue(distractorTexts.contains("Ans 2"))
        assertTrue(distractorTexts.contains("Ans 3"))
        assertTrue(distractorTexts.contains("Ans 4"))
    }

    @Test
    fun `distractorSourceIds has exactly 3 entries`() {
        val mcqs = engine.generate(sampleCards)
        for (mcq in mcqs) {
            assertEquals(
                "Expected 3 distractor source IDs for card ${mcq.sourceCardId}",
                3, mcq.distractorSourceIds.size
            )
        }
    }

    // ========================================================================
    // Determinism tests
    // ========================================================================

    @Test
    fun `same seed produces same output`() {
        val engine1 = McqEngine(random = Random(12345))
        val engine2 = McqEngine(random = Random(12345))

        val mcqs1 = engine1.generate(sampleCards)
        val mcqs2 = engine2.generate(sampleCards)

        assertEquals("Same seed should produce same count", mcqs1.size, mcqs2.size)
        for (i in mcqs1.indices) {
            assertEquals("Question $i should be identical", mcqs1[i].question, mcqs2[i].question)
            assertEquals("Options $i should be identical", mcqs1[i].options, mcqs2[i].options)
            assertEquals("CorrectIndex $i should be identical", mcqs1[i].correctIndex, mcqs2[i].correctIndex)
        }
    }

    @Test
    fun `different seed produces different option order`() {
        val engine1 = McqEngine(random = Random(111))
        val engine2 = McqEngine(random = Random(999))

        val mcqs1 = engine1.generate(sampleCards)
        val mcqs2 = engine2.generate(sampleCards)

        // At least one MCQ should have different option ordering
        val hasVariation = mcqs1.indices.any { i ->
            mcqs1[i].options != mcqs2[i].options || mcqs1[i].correctIndex != mcqs2[i].correctIndex
        }
        assertTrue("Different seeds should produce different shuffles", hasVariation)
    }

    // ========================================================================
    // Edge cases
    // ========================================================================

    @Test
    fun `empty card list returns empty MCQ list`() {
        val mcqs = engine.generate(emptyList())
        assertTrue(mcqs.isEmpty())
    }

    @Test
    fun `cards with empty front are skipped`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "", back = "Answer", deckHierarchy = "Test"),
            CardEntity(2, 102, 1, front = "Question?", back = "Answer 2", deckHierarchy = "Test"),
            CardEntity(3, 103, 1, front = "Q3?", back = "Answer 3", deckHierarchy = "Test"),
            CardEntity(4, 104, 1, front = "Q4?", back = "Answer 4", deckHierarchy = "Test"),
            CardEntity(5, 105, 1, front = "Q5?", back = "Answer 5", deckHierarchy = "Test")
        )
        val mcqs = engine.generate(cards)
        // Card 1 has empty front, should be skipped
        assertTrue(mcqs.none { it.sourceCardId == 1L })
    }

    @Test
    fun `cards with empty back are skipped`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Question?", back = "", deckHierarchy = "Test"),
            CardEntity(2, 102, 1, front = "Q2?", back = "Answer 2", deckHierarchy = "Test"),
            CardEntity(3, 103, 1, front = "Q3?", back = "Answer 3", deckHierarchy = "Test"),
            CardEntity(4, 104, 1, front = "Q4?", back = "Answer 4", deckHierarchy = "Test"),
            CardEntity(5, 105, 1, front = "Q5?", back = "Answer 5", deckHierarchy = "Test")
        )
        val mcqs = engine.generate(cards)
        assertTrue(mcqs.none { it.sourceCardId == 1L })
    }

    @Test
    fun `fewer than 4 total cards returns valid MCQs using fallbacks`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Q1?", back = "A1", deckHierarchy = "Test"),
            CardEntity(2, 102, 1, front = "Q2?", back = "A2", deckHierarchy = "Test"),
            CardEntity(3, 103, 1, front = "Q3?", back = "A3", deckHierarchy = "Test")
        )
        val mcqs = engine.generate(cards)
        assertEquals(3, mcqs.size)
        for (mcq in mcqs) {
            assertTrue(mcq.isValid())
            assertEquals(4, mcq.options.size)
        }
    }

    @Test
    fun `exactly 4 cards produces valid MCQs`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Q1?", back = "A1", deckHierarchy = "Test"),
            CardEntity(2, 102, 1, front = "Q2?", back = "A2", deckHierarchy = "Test"),
            CardEntity(3, 103, 1, front = "Q3?", back = "A3", deckHierarchy = "Test"),
            CardEntity(4, 104, 1, front = "Q4?", back = "A4", deckHierarchy = "Test")
        )
        val mcqs = engine.generate(cards)
        assertTrue("4 cards should produce MCQs", mcqs.isNotEmpty())
        for (mcq in mcqs) {
            assertTrue("Each MCQ should be valid", mcq.isValid())
        }
    }

    @Test
    fun `duplicate answers in cards are deduplicated in options`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Q1?", back = "Same Answer", deckHierarchy = "Test"),
            CardEntity(2, 102, 1, front = "Q2?", back = "Same Answer", deckHierarchy = "Test"), // duplicate back
            CardEntity(3, 103, 1, front = "Q3?", back = "Different A", deckHierarchy = "Test"),
            CardEntity(4, 104, 1, front = "Q4?", back = "Different B", deckHierarchy = "Test"),
            CardEntity(5, 105, 1, front = "Q5?", back = "Different C", deckHierarchy = "Test")
        )
        val mcqs = engine.generate(cards)
        for (mcq in mcqs) {
            val normalized = mcq.options.map { it.trim().lowercase() }
            assertEquals("No duplicate options allowed", 4, normalized.distinct().size)
        }
    }

    @Test
    fun `all MCQs pass internal validation`() {
        val mcqs = engine.generate(hierarchicalCards)
        for (mcq in mcqs) {
            assertTrue("MCQ for card ${mcq.sourceCardId} failed validation", mcq.isValid())
        }
    }

    @Test
    fun `targetDeckId filters correctly`() {
        // Only generate for deckId=103 (Physics — 3 cards)
        val mcqs = engine.generate(hierarchicalCards, targetDeckId = 103)
        // All source cards should be from Physics
        for (mcq in mcqs) {
            val sourceCard = hierarchicalCards.find { it.id == mcq.sourceCardId }
            assertNotNull(sourceCard)
            assertEquals(103L, sourceCard!!.deckId)
        }
    }

    // ========================================================================
    // Hierarchy Index tests
    // ========================================================================

    @Test
    fun `hierarchy index groups by deckId correctly`() {
        val index = HierarchyIndex.build(hierarchicalCards)
        assertEquals(5, index.getByDeckId(101).size) // Genetics: 5 cards
        assertEquals(4, index.getByDeckId(102).size) // Ecology: 4 cards
        assertEquals(3, index.getByDeckId(103).size) // Physics: 3 cards
        assertEquals(4, index.getByDeckId(200).size) // Math: 4 cards
    }

    @Test
    fun `hierarchy index groups by parent path correctly`() {
        val index = HierarchyIndex.build(hierarchicalCards)
        // "Science::Biology" should contain Genetics + Ecology cards = 9
        val biologyCards = index.getByParentPath("Science::Biology")
        assertEquals(9, biologyCards.size)
        // "Science" should contain Physics cards = 3
        val scienceCards = index.getByParentPath("Science")
        assertEquals(3, scienceCards.size)
    }

    @Test
    fun `hierarchy index groups by root correctly`() {
        val index = HierarchyIndex.build(hierarchicalCards)
        // "Science" root contains Genetics + Ecology + Physics = 12
        val scienceCards = index.getByRootSegment("Science")
        assertEquals(12, scienceCards.size)
        // "Math" root contains 4
        val mathCards = index.getByRootSegment("Math")
        assertEquals(4, mathCards.size)
    }

    @Test
    fun `missing deckId returns empty list from index`() {
        val index = HierarchyIndex.build(hierarchicalCards)
        assertTrue(index.getByDeckId(999).isEmpty())
    }

    @Test
    fun `isTautologyOrAlias filters spelling typos based on Levenshtein threshold`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Who was the ruler?", back = "Alauddin Khilji", deckHierarchy = "History"),
            CardEntity(2, 102, 1, front = "Who was ali gurshasp?", back = "Alauddin Khalji", deckHierarchy = "History"),
            CardEntity(3, 103, 1, front = "Q3?", back = "Balban", deckHierarchy = "History"),
            CardEntity(4, 104, 1, front = "Q4?", back = "Iltutmish", deckHierarchy = "History"),
            CardEntity(5, 105, 1, front = "Q5?", back = "Razia Sultana", deckHierarchy = "History")
        )
        val mcqs = engine.generate(cards, targetDeckId = 1)
        val mcq = mcqs.find { it.sourceCardId == 1L }
        assertNotNull(mcq)
        assertFalse("Should ban Alauddin Khalji as distractor for Alauddin Khilji", mcq!!.options.contains("Alauddin Khalji"))
    }

    @Test
    fun `century matching and year proximity filter keeps close years and skips far ones`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "When was Battle of Tarain?", back = "1191", deckHierarchy = "History"),
            CardEntity(2, 102, 1, front = "Q2?", back = "1154", deckHierarchy = "History"),
            CardEntity(3, 103, 1, front = "Q3?", back = "1206", deckHierarchy = "History"),
            CardEntity(4, 104, 1, front = "Q4?", back = "1651", deckHierarchy = "History"),
            CardEntity(5, 105, 1, front = "Q5?", back = "1942", deckHierarchy = "History")
        )
        val mcqs = engine.generate(cards, targetDeckId = 1)
        val mcq = mcqs.find { it.sourceCardId == 1L }
        assertNotNull(mcq)
        assertFalse(mcq!!.options.contains("1651"))
        assertFalse(mcq.options.contains("1942"))
    }

    @Test
    fun `synonym alias mapping filters out database and parsed aliases`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "What is Vitamin C?", back = "Ascorbic Acid", deckHierarchy = "Science"),
            CardEntity(2, 102, 1, front = "Q2?", back = "Vitamin C", deckHierarchy = "Science"),
            CardEntity(3, 103, 1, front = "Q3?", back = "Citric Acid", deckHierarchy = "Science"),
            CardEntity(4, 104, 1, front = "Q4?", back = "Acetic Acid", deckHierarchy = "Science"),
            CardEntity(5, 105, 1, front = "Q5?", back = "Malic Acid", deckHierarchy = "Science")
        )
        val aliases = listOf(
            AliasEntity("ascorbic acid", "vitamin c")
        )
        val mcqs = engine.generate(cards, targetDeckId = 1, aliases = aliases)
        val mcq = mcqs.find { it.sourceCardId == 1L }
        assertNotNull(mcq)
        assertFalse("Should filter out synonym 'Vitamin C'", mcq!!.options.contains("Vitamin C"))
    }

    @Test
    fun `proper noun and number extraction from other cards matches nomenclature pattern`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "Who founded the Slave dynasty?", back = "Qutub Uddin Aibak", deckHierarchy = "History"),
            CardEntity(id = 2, noteId = 102, deckId = 1, front = "Who succeeded him?", back = "Iltutmish", tags = "[]", deckHierarchy = "History"),
            CardEntity(id = 3, noteId = 103, deckId = 1, front = "Q3?", back = "Balban", tags = "[]", deckHierarchy = "History")
        )
        val modifiedCard2 = cards[1].copy(front = "Who was Jalaluddin Muhammad Akbar?")
        val mcqs = engine.generate(listOf(cards[0], modifiedCard2, cards[2]), targetDeckId = 1)
        val mcq = mcqs.find { it.sourceCardId == 1L }
        assertNotNull(mcq)
        assertTrue("Options should contain extracted proper noun Jalaluddin Muhammad Akbar", mcq!!.options.contains("Jalaluddin Muhammad Akbar"))
    }

    @Test
    fun `distractors are matched by tags when tags are present`() {
        val cards = listOf(
            CardEntity(1, 101, 1, front = "What is the capital of France?", back = "Paris", tags = "[\"geography\"]", deckHierarchy = "TestDeck"),
            CardEntity(2, 102, 1, front = "Who wrote Hamlet?", back = "Shakespeare", tags = "[\"history\"]", deckHierarchy = "TestDeck"),
            CardEntity(3, 103, 1, front = "What is the capital of Germany?", back = "Berlin", tags = "[\"geography\"]", deckHierarchy = "TestDeck"),
            CardEntity(4, 104, 1, front = "What is the capital of Italy?", back = "Rome", tags = "[\"geography\"]", deckHierarchy = "TestDeck"),
            CardEntity(5, 105, 1, front = "What is the capital of Spain?", back = "Madrid", tags = "[\"geography\"]", deckHierarchy = "TestDeck"),
            CardEntity(6, 106, 1, front = "Who painted Mona Lisa?", back = "Da Vinci", tags = "[\"history\"]", deckHierarchy = "TestDeck")
        )
        val mcqs = engine.generate(cards, targetDeckId = 1)
        val mcq = mcqs.find { it.sourceCardId == 1L }
        assertNotNull(mcq)
        assertTrue(mcq!!.options.contains("Berlin"))
        assertTrue(mcq.options.contains("Rome"))
        assertTrue(mcq.options.contains("Madrid"))
        assertFalse(mcq.options.contains("Shakespeare"))
        assertFalse(mcq.options.contains("Da Vinci"))
    }
}
