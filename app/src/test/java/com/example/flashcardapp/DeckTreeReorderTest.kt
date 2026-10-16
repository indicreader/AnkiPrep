package com.example.flashcardapp

import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.ui.DeckNode
import com.example.flashcardapp.ui.buildDeckTree
import com.example.flashcardapp.ui.findSiblingsAndIndex
import com.example.flashcardapp.ui.collectAllDeckIds
import org.junit.Assert.*
import org.junit.Test

class DeckTreeReorderTest {

    @Test
    fun testBuildDeckTreePreservesHierarchy() {
        val decks = listOf(
            AnkiDeck(id = 1L, name = "History", cardCount = 10),
            AnkiDeck(id = 2L, name = "History::Ancient", cardCount = 5),
            AnkiDeck(id = 3L, name = "History::Medieval", cardCount = 5),
            AnkiDeck(id = 4L, name = "Science", cardCount = 20),
            AnkiDeck(id = 5L, name = "Science::Physics", cardCount = 12)
        )

        val tree = buildDeckTree(decks)
        assertEquals(2, tree.size)
        assertEquals("History", tree[0].shortName)
        assertEquals(2, tree[0].children.size)
        assertEquals("Ancient", tree[0].children[0].shortName)
        assertEquals("Medieval", tree[0].children[1].shortName)

        assertEquals("Science", tree[1].shortName)
        assertEquals(1, tree[1].children.size)
        assertEquals("Physics", tree[1].children[0].shortName)
    }

    @Test
    fun testFindSiblingsAndIndexForRootAndChildren() {
        val decks = listOf(
            AnkiDeck(id = 1L, name = "A", cardCount = 1),
            AnkiDeck(id = 2L, name = "A::A1", cardCount = 1),
            AnkiDeck(id = 3L, name = "A::A2", cardCount = 1),
            AnkiDeck(id = 4L, name = "B", cardCount = 1)
        )
        val tree = buildDeckTree(decks)

        // Find root node B
        val rootResult = findSiblingsAndIndex(tree, "B")
        assertNotNull(rootResult)
        val (rootSibs, rootIdx) = rootResult!!
        assertEquals(1, rootIdx)
        assertEquals(2, rootSibs.size)

        // Find child node A::A2
        val childResult = findSiblingsAndIndex(tree, "A::A2")
        assertNotNull(childResult)
        val (childSibs, childIdx) = childResult!!
        assertEquals(1, childIdx)
        assertEquals(2, childSibs.size)
        assertEquals("A::A1", childSibs[0].fullPath)
        assertEquals("A::A2", childSibs[1].fullPath)
    }

    @Test
    fun testSiblingSwapWithinChildGroup() {
        val decks = listOf(
            AnkiDeck(id = 1L, name = "Topic", cardCount = 1),
            AnkiDeck(id = 2L, name = "Topic::Part 1", cardCount = 1),
            AnkiDeck(id = 3L, name = "Topic::Part 2", cardCount = 1),
            AnkiDeck(id = 4L, name = "Topic::Part 3", cardCount = 1)
        )
        val tree = buildDeckTree(decks)

        val (siblings, idx) = findSiblingsAndIndex(tree, "Topic::Part 3")!!
        assertEquals(2, idx)

        // Move Part 3 to index 0 (top of siblings)
        val moved = siblings.removeAt(idx)
        siblings.add(0, moved)

        assertEquals("Topic::Part 3", siblings[0].fullPath)
        assertEquals("Topic::Part 1", siblings[1].fullPath)
        assertEquals("Topic::Part 2", siblings[2].fullPath)

        val orderedIds = collectAllDeckIds(tree, decks)
        // Topic (1) -> Part 3 (4) -> Part 1 (2) -> Part 2 (3)
        assertEquals(listOf(1L, 4L, 2L, 3L), orderedIds)
    }

    @Test
    fun testCollectAllDeckIdsResolvesParentIdsEvenIfVirtual() {
        // Here parent "Geography" is not explicitly declared as a leaf deck, but exists in allDecks map
        val allDecks = listOf(
            AnkiDeck(id = 100L, name = "Geography", cardCount = 0),
            AnkiDeck(id = 101L, name = "Geography::Rivers", cardCount = 10),
            AnkiDeck(id = 102L, name = "Geography::Mountains", cardCount = 15)
        )
        // tree built only from leaf subdecks
        val leafDecks = listOf(allDecks[1], allDecks[2])
        val tree = buildDeckTree(leafDecks)

        // tree[0] has deck == null because Geography wasn't in leafDecks directly
        assertNull(tree[0].deck)

        // collectAllDeckIds with allDecks resolves Geography id (100L) from allDecks!
        val ids = collectAllDeckIds(tree, allDecks)
        assertEquals(listOf(100L, 101L, 102L), ids)
    }

    @Test
    fun testRootSiblingReorderingMovesEntireSubtree() {
        val decks = listOf(
            AnkiDeck(id = 1L, name = "Alpha", cardCount = 1),
            AnkiDeck(id = 2L, name = "Alpha::Sub1", cardCount = 1),
            AnkiDeck(id = 3L, name = "Beta", cardCount = 1),
            AnkiDeck(id = 4L, name = "Beta::Sub2", cardCount = 1)
        )
        val tree = buildDeckTree(decks).toMutableList()

        val (rootSibs, idx) = findSiblingsAndIndex(tree, "Beta")!!
        val moved = rootSibs.removeAt(idx)
        rootSibs.add(0, moved)

        val ids = collectAllDeckIds(rootSibs, decks)
        // Beta (3) -> Beta::Sub2 (4) -> Alpha (1) -> Alpha::Sub1 (2)
        assertEquals(listOf(3L, 4L, 1L, 2L), ids)
    }
}
