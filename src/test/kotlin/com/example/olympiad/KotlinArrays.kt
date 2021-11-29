package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

// Workout for kotlin array syntax
class KotlinArrays {

    @Test
    fun testCanInitialize1DArray() {
        val a1 = arrayOf(1, 2, 3)
        assertTrue(a1 contentEquals arrayOf(1, 2, 3))

        val a1To5 = Array(5) { i -> i + 1 }
        assertTrue(a1To5 contentEquals arrayOf(1, 2, 3, 4, 5))

        val zeroArray = Array(3) { 0 }
        assertTrue(zeroArray contentEquals arrayOf(0, 0, 0))

        val to4Array = Array(5) { it }
        assertTrue(to4Array contentEquals arrayOf(0, 1, 2, 3, 4))
    }

    @Test
    fun testCanInitialize2DArray() {
        val rows = 5
        val cols = 5

        val matrix = Array(rows) { i -> Array<Int>(cols) { i -> i + 1 } }

        for (row in matrix) {
            for (elem in row) {
                print(elem)
            }
            println()
        }

        matrix.forEach { row -> assertTrue(row contentEquals arrayOf(1, 2, 3, 4, 5)) }
    }
}
