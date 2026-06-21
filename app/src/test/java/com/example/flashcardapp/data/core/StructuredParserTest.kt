package com.example.flashcardapp.data.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StructuredParserTest {

    @Test
    fun `test missing tags`() {
        val content = "This is a simple question without any explanation tag."
        val parsed = StructuredParser.parse(content)
        assertEquals(content, parsed.answer)
        assertEquals("", parsed.explanation)
        assertTrue(parsed.hints.isEmpty())
        assertTrue(parsed.metadata.isEmpty())
        assertEquals(content, parsed.rawContent)
    }

    @Test
    fun `test typo aliases and identical treatment`() {
        val content1 = "What is 2+2?\n{explain}\nIt is 4."
        val parsed1 = StructuredParser.parse(content1)
        assertEquals("What is 2+2?", parsed1.answer)
        assertEquals("It is 4.", parsed1.explanation)

        val content2 = "What is 2+2?\n{explanation}\nIt is 4."
        val parsed2 = StructuredParser.parse(content2)
        assertEquals("What is 2+2?", parsed2.answer)
        assertEquals("It is 4.", parsed2.explanation)

        val content3 = "What is 2+2?\n{explaination}\nIt is 4."
        val parsed3 = StructuredParser.parse(content3)
        assertEquals("What is 2+2?", parsed3.answer)
        assertEquals("It is 4.", parsed3.explanation)
    }

    @Test
    fun `test empty explanation`() {
        val content = "What is gravity?\n{explain}\n"
        val parsed = StructuredParser.parse(content)
        assertEquals("What is gravity?", parsed.answer)
        assertEquals("", parsed.explanation)
    }

    @Test
    fun `test long content parsing with future tags`() {
        val content = """
            Solve for x: x^2 - 5x + 6 = 0
            {hint}
            Factor the quadratic equation.
            {hint}
            The product of the roots is 6, and the sum is 5.
            {explain}
            We can write the equation as (x - 2)(x - 3) = 0.
            Therefore, x = 2 or x = 3.
            {mnemonic}
            Sum is -b/a, product is c/a.
            {formula}
            x = (-b ± √(b^2 - 4ac)) / 2a
            {warning}
            Don't forget to check both solutions.
            {memorytrap}
            Watch out for sign errors when factoring!
        """.trimIndent()

        val parsed = StructuredParser.parse(content)

        assertEquals("Solve for x: x^2 - 5x + 6 = 0", parsed.answer)
        assertEquals(
            "We can write the equation as (x - 2)(x - 3) = 0.\nTherefore, x = 2 or x = 3.",
            parsed.explanation
        )
        assertEquals(2, parsed.hints.size)
        assertEquals("Factor the quadratic equation.", parsed.hints[0])
        assertEquals("The product of the roots is 6, and the sum is 5.", parsed.hints[1])

        assertEquals("Sum is -b/a, product is c/a.", parsed.metadata["mnemonic"])
        assertEquals("x = (-b ± √(b^2 - 4ac)) / 2a", parsed.metadata["formula"])
        assertEquals("Don't forget to check both solutions.", parsed.metadata["warning"])
        assertEquals("Watch out for sign errors when factoring!", parsed.metadata["memorytrap"])
        assertEquals(content, parsed.rawContent)
    }

    @Test
    fun `test parseCard with front MCQ format`() {
        val front = "[647] Black soil is ideal for the cultivation of which crop?: Cotton |Rice|Wheat|Tea| Black soil"
        val back = "Black soil"
        val parsed = StructuredParser.parseCard(front, back)

        assertEquals("[647] Black soil is ideal for the cultivation of which crop?", parsed.question)
        assertEquals("Cotton", parsed.answer)
        assertEquals("Black soil", parsed.explanation)
        assertEquals(listOf("Rice", "Wheat", "Tea"), parsed.options)
    }

    @Test
    fun `test parseCard with front MCQ format and no colon`() {
        val front = "What is 2+2? | 4 | 3 | 5 | 2"
        val back = "4"
        val parsed = StructuredParser.parseCard(front, back)

        assertEquals("What is 2+2?", parsed.question)
        assertEquals("4", parsed.answer)
        assertEquals(listOf("3", "5", "2"), parsed.options)
    }

    @Test
    fun `test parse with semicolon and pipe`() {
        val content = "Paris | London | Berlin | Rome ; Paris is the capital of France"
        val parsed = StructuredParser.parse(content)
        assertEquals("Paris", parsed.answer)
        assertEquals(listOf("London", "Berlin", "Rome"), parsed.options)
        assertEquals("Paris is the capital of France", parsed.explanation)
    }

    @Test
    fun `test parseCard with comma separated MCQ format`() {
        val front = "What is the capital of France, Paris | London | Rome | Berlin ; Paris is capital"
        val back = ""
        val parsed = StructuredParser.parseCard(front, back)

        assertEquals("What is the capital of France", parsed.question)
        assertEquals("Paris", parsed.answer)
        assertEquals(listOf("London", "Rome", "Berlin"), parsed.options)
        assertEquals("Paris is capital", parsed.explanation)
    }

    @Test
    fun `test parseCard with one-liner comma separated QA card`() {
        val front = "Which planet is closest to the Sun?, Mercury, Mercury is the first planet"
        val back = ""
        val parsed = StructuredParser.parseCard(front, back)

        assertEquals("Which planet is closest to the Sun?", parsed.question)
        assertEquals("Mercury", parsed.answer)
        assertEquals("Mercury is the first planet", parsed.explanation)
    }

    @Test
    fun `test parseCard with one-liner card and no explanation`() {
        val front = "Which planet is closest to the Sun?, Mercury"
        val back = ""
        val parsed = StructuredParser.parseCard(front, back)

        assertEquals("Which planet is closest to the Sun?", parsed.question)
        assertEquals("Mercury", parsed.answer)
        assertEquals("", parsed.explanation)
    }
}
