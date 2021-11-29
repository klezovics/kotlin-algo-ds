package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

// OK, so what can we do with sets ...
// Add/Remove elements
// Look for elements which match specific criteria 
// Chunk/Group elements
// Do queries on sets
// Take and drop
class KotlinSet {

    @Test
    fun testCanCreateSet() {
        val s = setOf(1, 2, 3)
        val s1 = setOf(1, 2, 3)
        assertTrue(s.containsAll(s1) && s1.containsAll(s))
    }

    @Test
    fun testCanGetMinMax() {
        val s = mutableSetOf<Int>()
        s.add(1)
        s.add(2)
        s.add(3)
        assertEquals(3, s.maxOrNull())
        assertEquals(1, s.minOrNull())
        assertEquals(2.0, s.average(), 0.1)

        val s1 = mutableSetOf<Int>()
        assertNull(s1.maxOrNull())
        assertEquals(Double.NaN, s1.average())
    }

    @Test
    fun testCanUseSexIndexing() {
        val words = mutableSetOf("a", "b", "c")
        assertEquals("a", words.elementAt(0))
        assertEquals(1, words.indexOf("b"))
        assertEquals(2, words.lastIndexOf("c"))
    }

    @Test
    fun testCanCountElementsMatchingCriteria() {
        val nums = setOf(1, 2, 3, 4)
        assertEquals(2, nums.count { it % 2 == 0 })
    }

    @Test
    fun testCanFindElementsMatchingCriteria() {
        val nums = setOf(1, 2, 3, 10, 20, 30, 100, 200)
        nums.forEach { println(it) }

        assertEquals(10, nums.firstOrNull { it > 5 })
        assertEquals(30, nums.lastOrNull { it < 100 })
    }

    @Test
    fun testCanIterateOverSetsWithIndexes() {
        val nums = setOf(1, 2, 3, 10, 20, 30, 100, 200)
        nums.forEachIndexed { i, e -> println("idx $i - elem $e") }
    }

    @Test
    fun testSetInclusionOperations() {
        val nums = setOf(1, 2, 3, 4)
        assertTrue(nums.contains(2))
        assertTrue(nums.containsAll(listOf(2, 3)))
    }

    @Test
    fun testCanUseMutableSet() {
        val nums = mutableSetOf(1, 2, 3, 4)
        nums.retainAll(listOf(2, 3))
        assertTrue(nums.size == 2)
        assertTrue(nums.containsAll(listOf(2, 3)))
    }

    @Test
    fun testCanDoSetUnion() {
        val n1 = setOf(1, 2)
        val n2 = setOf(2, 3)
        val n3 = n1.union(n2)

        assertTrue(n3.containsAll(listOf(1, 2, 3)))
    }

    data class Car(var name: String, var price: Int)

    @Test
    fun testCanFindMaxByFieldValue() {
        val cars = setOf(
            Car("Mazda", 6300), Car("Toyota", 12400),
            Car("Skoda", 5670), Car("Mercedes", 18600)
        )

        val car = cars.maxByOrNull { it.price }
        assertEquals("Mercedes", car!!.name)
    }

    @Test
    fun testCanReduceSet() {
        val nums = setOf(1, 2, 3, 4)
        assertEquals(10, nums.reduce { total, next -> total + next })
    }

    @Test
    fun testCanChunkSets() {
        val nums = setOf(1, 2, 3, 4, 5)
        val chunks = nums.chunked(2)
        assertEquals(3, chunks.size)

        assertTrue(chunks[0].toTypedArray() contentEquals arrayOf(1, 2))
        assertTrue(chunks[1].toTypedArray() contentEquals arrayOf(3, 4))
        assertTrue(chunks[2].toTypedArray() contentEquals arrayOf(5))
    }

    @Test
    fun testCanPartitionSet() {
        val nums = setOf(-1, -2, 1, 2)
        val (positive, negative) = nums.partition { it > 0 }

        assertTrue(positive.toTypedArray() contentEquals arrayOf(1, 2))
        assertTrue(negative.toTypedArray() contentEquals arrayOf(-1, -2))

        val l = listOf(-1, -2, 1, 2)
        assertTrue(l.dropLastWhile { it > 0 }.toTypedArray() contentEquals arrayOf(-1, -2))
    }

    @Test
    fun testCanQuerySets() {
        assertTrue(setOf(-1, -2, 1).any { it > 0 })
        assertFalse(setOf(-1, -2, -100).any { it > 0 })

        assertTrue(setOf(1, 2).all { it > 0 })
        assertFalse(setOf(-1, 2).all { it > 0 })
    }

    @Test
    fun testCanDropElements() {
        val nums = setOf(-1, -2, 2, 3)
        assertTrue(nums.drop(2).toTypedArray() contentEquals arrayOf(2, 3))
        assertTrue(nums.dropWhile { it < 0 }.toTypedArray() contentEquals arrayOf(2, 3))
    }

    @Test
    fun testCanTakeElements() {
        val nums = setOf(-1, 1, -2, 2, -3, 3)
        val l = nums.sorted()

        assertTrue(l.takeLastWhile { it > 0 }.toTypedArray() contentEquals arrayOf(1, 2, 3))
    }
}
