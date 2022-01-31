package com.example.olympiad

import org.junit.jupiter.api.Test

class UsefulNotesTest {

    @Test
    fun testCanSortBySeveralFields() {
        val coords = arrayOf(
            intArrayOf(0, 3),
            intArrayOf(0, 1),
            intArrayOf(0, 7),
            intArrayOf(2, 100),
            intArrayOf(2, 2)
        )

        val nc = coords.sortedWith(compareBy({ it[0] }, { it[1] }))
        nc.forEach {
            println("${it[0]},${it[1]}")
        }
        nc.size
    }
}
