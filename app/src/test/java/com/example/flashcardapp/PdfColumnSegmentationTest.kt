package com.example.flashcardapp

import com.example.flashcardapp.data.PdfColumnMode
import com.example.flashcardapp.data.PdfImporter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PdfColumnSegmentationTest {

    @Test
    fun testParseQuestionsFromBookletText() {
        val rawBookletText = """
            Chapter 1: Indian Polity
            
            1. Which Article of the Indian Constitution provides for the Election Commission?
            (a) Article 324
            (b) Article 356
            (c) Article 370
            (d) Article 368
            Ans: (a)
            Expl:- Article 324 provides for superintendence, direction, and control of elections.
            
            2. The concept of Fundamental Duties was borrowed from which country?
            (A) USA
            (B) USSR
            (C) UK
            (D) France
            Answer: B
            Explanation: Fundamental duties were added by 42nd Amendment inspired by USSR constitution.
        """.trimIndent()

        val cards = PdfImporter.parseExtractedQuestions(
            text = rawBookletText,
            deckName = "Indian Polity",
            deckId = 101L
        )

        assertEquals(2, cards.size)

        // Question 1 Verification
        val q1 = cards[0]
        assertTrue(q1.front.contains("Article of the Indian Constitution provides for the Election Commission"))
        assertTrue(q1.back.contains("Article 324"))
        assertTrue(q1.back.contains("Article 356"))
        assertTrue(q1.back.contains("{explain}"))
        assertTrue(q1.back.contains("superintendence, direction"))

        // Question 2 Verification
        val q2 = cards[1]
        assertTrue(q2.front.contains("concept of Fundamental Duties was borrowed"))
        assertTrue(q2.back.startsWith("USSR"))
        assertTrue(q2.back.contains("USA"))
        assertTrue(q2.back.contains("42nd Amendment inspired by USSR"))
    }

    @Test
    fun testSequentialReadingOrderAvoidsCrossTalk() {
        // Simulating 2-column text: Col 1 has Q1 & Q2, Col 2 has Q3 & Q4
        val col1Text = """
            1. Question in Left Column 1
            (a) Left 1
            (b) Left 2
            (c) Left 3
            (d) Left 4
            Ans: (a)
            
            2. Question in Left Column 2
            (a) Left 2A
            (b) Left 2B
            (c) Left 2C
            (d) Left 2D
            Ans: (b)
        """.trimIndent()

        val col2Text = """
            3. Question in Right Column 1
            (a) Right 1
            (b) Right 2
            (c) Right 3
            (d) Right 4
            Ans: (c)
        """.trimIndent()

        val fullSequentialText = col1Text + "\n" + col2Text

        val cards = PdfImporter.parseExtractedQuestions(
            text = fullSequentialText,
            deckName = "Two Column Test",
            deckId = 202L
        )

        assertEquals(3, cards.size)
        assertEquals("Question in Left Column 1", cards[0].front)
        assertEquals("Question in Left Column 2", cards[1].front)
        assertEquals("Question in Right Column 1", cards[2].front)
    }

    @Test
    fun testInlineOptionsAndNumberedFormat() {
        val mixedText = """
            1. Which planet is closest to the Sun?
            (1) Venus  (2) Mercury  (3) Mars  (4) Earth
            Ans: 2
            Expl: Mercury is the innermost planet.

            2. What is the currency of Japan? [Ans: (b)]
            (a) Yuan  (b) Yen  (c) Won  (d) Ringgit
        """.trimIndent()

        val cards = PdfImporter.parseExtractedQuestions(
            text = mixedText,
            deckName = "General Science",
            deckId = 303L
        )

        assertEquals(2, cards.size)

        // Q1 with numbered options (1)-(4) and Ans: 2
        val q1 = cards[0]
        assertTrue(q1.front.contains("Which planet is closest to the Sun"))
        assertTrue(q1.back.startsWith("Mercury"))
        assertTrue(q1.back.contains("Venus"))
        assertTrue(q1.back.contains("{explain}"))

        // Q2 with inline answer [Ans: (b)]
        val q2 = cards[1]
        assertTrue(q2.front.contains("What is the currency of Japan"))
        assertTrue(q2.back.startsWith("Yen"))
        assertTrue(q2.back.contains("Yuan"))
    }

    @Test
    fun testAnswerKeyAtEndOfDocument() {
        val bookletWithKeyAtEnd = """
            1. What is the chemical symbol for Gold?
            (a) Ag
            (b) Au
            (c) Fe
            (d) Cu

            2. What is the speed of light in vacuum?
            (1) 3 x 10^8 m/s
            (2) 3 x 10^6 m/s
            (3) 3 x 10^5 km/s
            (4) Both 1 and 3

            Answer Key:
            1. (b)   2. (4)
        """.trimIndent()

        val cards = PdfImporter.parseExtractedQuestions(
            text = bookletWithKeyAtEnd,
            deckName = "Physics & Chemistry",
            deckId = 404L
        )

        assertEquals(2, cards.size)

        // Q1 answer mapped from Answer Key at end: 1 -> (b) -> Au
        val q1 = cards[0]
        assertTrue(q1.back.startsWith("Au"))
        assertTrue(q1.back.contains("Ag"))

        // Q2 answer mapped from Answer Key at end: 2 -> (4) -> Both 1 and 3
        val q2 = cards[1]
        assertTrue(q2.back.startsWith("Both 1 and 3"))
        assertTrue(q2.back.contains("3 x 10^8 m/s"))
    }

    @Test
    fun testIgnoreNotesAndExtractOneLiners() {
        val bookletWithNotesAndOneLiners = """
            PREFACE & DISCLAIMER
            All rights reserved. Copyright 2024 Exam Prep Publications.
            NOTE: This chapter covers the history of ancient India. Students should focus on Indus Valley civilization.
            
            1. Who was the founder of Maurya Dynasty?
            (a) Ashoka
            (b) Chandragupta Maurya
            (c) Bindusara
            (d) Harsha
            Ans: (b)
            Expl: Chandragupta Maurya founded the empire with Chanakya's help.
            
            IMPORTANT POINT:
            Ashoka embraced Buddhism after the Kalinga war in 261 BCE.
            
            2. First Battle of Panipat was fought in which year? - 1526
            
            SUMMARY:
            The Mughal empire flourished under Akbar.
            
            3. Who wrote Discovery of India? : Jawaharlal Nehru
        """.trimIndent()

        val cards = PdfImporter.parseExtractedQuestions(
            text = bookletWithNotesAndOneLiners,
            deckName = "History",
            deckId = 505L
        )

        assertEquals(3, cards.size)

        // Q1: Standard MCQ
        val q1 = cards[0]
        assertTrue(q1.front.contains("founder of Maurya Dynasty"))
        assertTrue(q1.back.startsWith("Chandragupta Maurya"))
        assertTrue(q1.back.contains("{explain}"))

        // Q2: One-liner with hyphen
        val q2 = cards[1]
        assertTrue(q2.front.contains("First Battle of Panipat was fought in which year?"))
        assertEquals("1526", q2.back.trim())

        // Q3: One-liner with colon
        val q3 = cards[2]
        assertTrue(q3.front.contains("Who wrote Discovery of India?"))
        assertEquals("Jawaharlal Nehru", q3.back.trim())
    }

    @Test
    fun testUniversalBookletFormats() {
        val diverseBooklet = """
            Chapter 5: Science and Technology
            Table of Contents
            Remember: Revise previous chapter formulas.

            Prob 1. Which organelle produces ATP in eukaryotic cells?
            (i) Ribosome
            (ii) Mitochondria
            (iii) Golgi apparatus
            (iv) Nucleus
            Right Answer: (ii)
            Explanation: Mitochondria is known as powerhouse of cell.

            Item 2. Photosynthesis occurs in which plant cell organelle?
            (1) Chloroplast  (2) Vacuole  (3) Cell Wall  (4) Centrosome
            Key: 1

            3. Light year is a unit of which quantity? -> Distance

            4. The speed of sound is faster in water than in air. (True/False)
            Ans: True
        """.trimIndent()

        val cards = PdfImporter.parseExtractedQuestions(
            text = diverseBooklet,
            deckName = "General Science",
            deckId = 606L
        )

        assertEquals(4, cards.size)

        // Prob 1: Roman numerals (i)-(iv)
        val q1 = cards[0]
        assertTrue(q1.front.contains("Which organelle produces ATP"))
        assertTrue(q1.back.startsWith("Mitochondria"))
        assertTrue(q1.back.contains("powerhouse of cell"))

        // Item 2: Numbered options with inline key
        val q2 = cards[1]
        assertTrue(q2.front.contains("Photosynthesis occurs in which plant cell organelle"))
        assertTrue(q2.back.startsWith("Chloroplast"))

        // Q3: One liner with arrow ->
        val q3 = cards[2]
        assertTrue(q3.front.contains("Light year is a unit of which quantity"))
        assertEquals("Distance", q3.back.trim())

        // Q4: True/False question
        val q4 = cards[3]
        assertTrue(q4.front.contains("speed of sound is faster in water than in air"))
        assertTrue(q4.back.contains("True"))
    }

    @Test
    fun testSerialNumbersAreIgnoredAndStripped() {
        val diverseNumberedText = """
            Q1. What is the national flower of India?
            (a) Lotus  (b) Rose  (c) Lily  (d) Marigold
            Ans: A

            Q. 2 Which gas is essential for human respiration?
            (a) Nitrogen  (b) Oxygen  (c) Argon  (d) Carbon dioxide
            Ans: B

            (3) Who discovered gravity?
            (a) Einstein  (b) Newton  (c) Galileo  (d) Bohr
            Ans: B

            [4] What is the boiling point of water at sea level?
            (a) 90 C  (b) 100 C  (c) 110 C  (d) 120 C
            Ans: B

            Question 5: Which is the largest ocean on Earth?
            (a) Atlantic  (b) Pacific  (c) Indian  (d) Arctic
            Ans: B
        """.trimIndent()

        val cards = PdfImporter.parseExtractedQuestions(
            text = diverseNumberedText,
            deckName = "Serials Test",
            deckId = 707L
        )

        assertEquals(5, cards.size)

        // All questions must have clean fronts with ZERO serial prefixes
        assertEquals("What is the national flower of India?", cards[0].front)
        assertEquals("Which gas is essential for human respiration?", cards[1].front)
        assertEquals("Who discovered gravity?", cards[2].front)
        assertEquals("What is the boiling point of water at sea level?", cards[3].front)
        assertEquals("Which is the largest ocean on Earth?", cards[4].front)
    }

    @Test
    fun testSegmentedExternalAnswerKeyAndExplanationMapping() {
        // Simulating Questions from one section/pages
        val questionsOnlyText = """
            Q1. What is the capital of Japan?
            (a) Beijing  (b) Tokyo  (c) Seoul  (d) Bangkok

            Q2. Which element has the chemical symbol Na?
            (a) Nitrogen  (b) Sodium  (c) Nickel  (d) Neon
        """.trimIndent()

        // Simulating Answer Key from another page/section
        val answerKeyText = """
            Answers:
            1. (b)
            2. (b)
        """.trimIndent()

        // Simulating Explanations from another page/section
        val explanationsText = """
            Sol. 1. Tokyo is the metropolitan capital of Japan.
            Sol. 2. Sodium comes from the Latin name Natrium.
        """.trimIndent()

        val answerKeyMap = PdfImporter.parseAnswerKey(answerKeyText)
        val explanationMap = PdfImporter.parseExplanations(explanationsText)

        assertEquals("B", answerKeyMap[1])
        assertEquals("B", answerKeyMap[2])
        assertTrue(explanationMap[1]?.contains("Tokyo is the metropolitan capital") == true)
        assertTrue(explanationMap[2]?.contains("Sodium comes from the Latin name") == true)

        val cards = PdfImporter.parseExtractedQuestions(
            text = questionsOnlyText,
            deckName = "Segmented Test",
            deckId = 808L,
            externalAnswerKeyMap = answerKeyMap,
            externalExplanationMap = explanationMap
        )

        assertEquals(2, cards.size)

        // Q1
        assertEquals("What is the capital of Japan?", cards[0].front)
        assertTrue(cards[0].back.startsWith("Tokyo"))
        assertTrue(cards[0].back.contains("Tokyo is the metropolitan capital of Japan"))

        // Q2
        assertEquals("Which element has the chemical symbol Na?", cards[1].front)
        assertTrue(cards[1].back.startsWith("Sodium"))
        assertTrue(cards[1].back.contains("Sodium comes from the Latin name Natrium"))
    }
}


