package com.example.flashcardapp.data.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FileImportUtilsTest {

    @Test
    fun testDecodeUtf8WithBom() {
        val text = "question,answer,tags\nWhat is 2+2?,4,Math"
        val bomBytes = byteArrayOf(0xEF.toByte(), 0xBB.toByte(), 0xBF.toByte())
        val fullBytes = bomBytes + text.toByteArray(Charsets.UTF_8)

        val decoded = FileImportUtils.decodeBytesWithAutoEncoding(fullBytes)
        assertEquals(text, decoded)
    }

    @Test
    fun testDecodeUtf16LeWithBom() {
        val text = "question,answer\nWhat is capital of France?,Paris"
        val bomBytes = byteArrayOf(0xFF.toByte(), 0xFE.toByte())
        val fullBytes = bomBytes + text.toByteArray(Charsets.UTF_16LE)

        val decoded = FileImportUtils.decodeBytesWithAutoEncoding(fullBytes)
        assertEquals(text, decoded)
    }

    @Test
    fun testDecodeUtf16BeWithBom() {
        val text = "question,answer\nWhat is the speed of light?,3x10^8 m/s"
        val bomBytes = byteArrayOf(0xFE.toByte(), 0xFF.toByte())
        val fullBytes = bomBytes + text.toByteArray(Charsets.UTF_16BE)

        val decoded = FileImportUtils.decodeBytesWithAutoEncoding(fullBytes)
        assertEquals(text, decoded)
    }

    @Test
    fun testDecodePlainUtf8WithoutBom() {
        val text = "question,answer\nWho wrote Hamlet?,William Shakespeare"
        val bytes = text.toByteArray(Charsets.UTF_8)

        val decoded = FileImportUtils.decodeBytesWithAutoEncoding(bytes)
        assertEquals(text, decoded)
    }

    @Test
    fun testEmptyBytesReturnsEmptyString() {
        val decoded = FileImportUtils.decodeBytesWithAutoEncoding(ByteArray(0))
        assertEquals("", decoded)
    }
}
