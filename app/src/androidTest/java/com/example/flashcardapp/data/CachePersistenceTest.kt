package com.example.flashcardapp.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.flashcardapp.data.dao.CardDao
import com.example.flashcardapp.data.dao.DeckDao
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented tests for Room database cache persistence.
 *
 * Validates that:
 * 1. Data written to Room can be read back
 * 2. Data survives database close/reopen (simulating app restart)
 * 3. Empty decks don't crash the system
 * 4. Card counts are accurate
 */
@RunWith(AndroidJUnit4::class)
class CachePersistenceTest {

    private lateinit var db: AppDatabase
    private lateinit var deckDao: DeckDao
    private lateinit var cardDao: CardDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Use a real (not in-memory) database to test persistence
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "test_ankiprep_cache.db"
        ).build()
        deckDao = db.deckDao()
        cardDao = db.cardDao()
    }

    @After
    fun closeDb() {
        db.close()
        // Clean up test database
        val context = ApplicationProvider.getApplicationContext<Context>()
        context.deleteDatabase("test_ankiprep_cache.db")
    }

    @Test
    fun canLoadAtLeastOneDeck() = runBlocking {
        val deck = DeckEntity(
            id = 1L,
            name = "Test Deck",
            fullPath = "Test Deck",
            cardCount = 0
        )
        deckDao.upsertDeck(deck)

        val decks = deckDao.getAllDecksOnce()
        assertTrue("Expected at least 1 deck", decks.isNotEmpty())
        assertEquals("Test Deck", decks.first().name)
    }

    @Test
    fun canExtractAtLeast10Cards() = runBlocking {
        // Insert parent deck first
        val deck = DeckEntity(id = 1L, name = "Test", fullPath = "Test")
        deckDao.upsertDeck(deck)

        // Insert 12 cards
        val cards = (1..12).map { i ->
            CardEntity(
                id = i.toLong(),
                noteId = (100 + i).toLong(),
                deckId = 1L,
                front = "Question $i",
                back = "Answer $i",
                tags = "[\"tag$i\"]",
                deckHierarchy = "Test"
            )
        }
        cardDao.upsertCards(cards)

        val count = cardDao.getCardCount()
        assertTrue("Expected ≥10 cards, got $count", count >= 10)
    }

    @Test
    fun cacheDataPersistsAfterDbReopen() = runBlocking {
        // Insert data
        val deck = DeckEntity(id = 1L, name = "Persist Test", fullPath = "Persist Test")
        deckDao.upsertDeck(deck)

        val card = CardEntity(
            id = 1L, noteId = 100L, deckId = 1L,
            front = "Persistent Q", back = "Persistent A",
            tags = "[\"persist\"]", deckHierarchy = "Persist Test"
        )
        cardDao.upsertCards(listOf(card))

        // Verify data exists
        val decksBefore = deckDao.getAllDecksOnce()
        val cardsBefore = cardDao.getAllCardsOnce()
        assertTrue(decksBefore.isNotEmpty())
        assertTrue(cardsBefore.isNotEmpty())

        // Close and reopen database (simulates app restart)
        db.close()
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "test_ankiprep_cache.db"
        ).build()
        deckDao = db.deckDao()
        cardDao = db.cardDao()

        // Verify data still exists after reopen
        val decksAfter = deckDao.getAllDecksOnce()
        val cardsAfter = cardDao.getAllCardsOnce()
        assertTrue("Decks should persist after restart", decksAfter.isNotEmpty())
        assertTrue("Cards should persist after restart", cardsAfter.isNotEmpty())
        assertEquals("Persist Test", decksAfter.first().name)
        assertEquals("Persistent Q", cardsAfter.first().front)
    }

    @Test
    fun emptyDeckDoesNotCrash() = runBlocking {
        // Insert a deck with no cards
        val emptyDeck = DeckEntity(id = 99L, name = "Empty", fullPath = "Empty", cardCount = 0)
        deckDao.upsertDeck(emptyDeck)

        // Query cards for this empty deck — should return empty list, not crash
        val cards = cardDao.getCardsForDeckOnce(99L)
        assertNotNull(cards)
        assertEquals(0, cards.size)

        // Sample cards should also work with empty data
        val samples = cardDao.getSampleCards(99L, 5)
        assertNotNull(samples)
        assertEquals(0, samples.size)

        // Count should be 0
        val count = cardDao.getCardCountForDeck(99L)
        assertEquals(0, count)
    }
}
