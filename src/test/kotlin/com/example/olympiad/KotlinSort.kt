package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinSort {

    @Test
    fun testCanSortByObjectField() {
        val dates = mutableListOf(
            MyDate(2020, 4, 3),
            MyDate(2021, 5, 16),
            MyDate(1918, 1, 1)
        )

        dates.sortBy { it.year }
        dates.forEach { println(it) }

        assertEquals(1918, dates[0].year)
        assertEquals(2020, dates[1].year)
        assertEquals(2021, dates[2].year)
    }

    @Test
    fun testCanSortByObjectFieldDescending() {
        val dates = mutableListOf(
            MyDate(2020, 4, 3),
            MyDate(2021, 5, 16),
            MyDate(1918, 1, 1)
        )

        dates.sortByDescending { it.year }
        dates.forEach { println(it) }

        assertEquals(2021, dates[0].year)
        assertEquals(2020, dates[1].year)
        assertEquals(1918, dates[2].year)
    }

    @Test
    fun testCanSaveSortResultsIntoAnotherList() {
        val dates = mutableListOf(
            MyDate(2020, 4, 3),
            MyDate(2021, 5, 16),
            MyDate(1918, 1, 1)
        )

        val sDates = dates.sortedBy { it.year }
        sDates.forEach { println(it) }

        assertEquals(1918, sDates[0].year)
        assertEquals(2020, sDates[1].year)
        assertEquals(2021, sDates[2].year)
    }
}

data class MyDate(val year: Int, val month: Int, val day: Int)
