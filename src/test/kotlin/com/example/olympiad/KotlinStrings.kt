package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KotlinStrings {

    @Test
    fun testStringBuilding() {
        val s = buildString {
            repeat(3) {
                append("a")
                append("bc")
            }
        }

        assertEquals("abcabcabc", s)
    }

    @Test
    fun testCanEfficientlyWorkWithBlanks() {
        assertTrue("  ".isBlank())
        assertFalse("  ".isNotBlank())
        assertTrue("".isEmpty())

        val neverBlank = " ".ifBlank { "Never Blank" }
        assertEquals("Never Blank", neverBlank)

        val a = "  zbad "
        assertEquals("zbad", a.trim())
    }

    @Test
    fun testCanCompareStringsAlphabetically() {
        assertTrue(if ("a" < "b") true else false)
    }

    @Test
    fun testRemoveSuffix() {
        val s = "##xxx##"
        assertEquals("xxx", s.removeSurrounding("##"))
    }

    @Test
    fun testCanSplitByLines() {
        val lines = """
            abc
            def
            geh
        """.trimIndent()

        assertEquals(3, lines.lines().size)
    }

    @Test
    fun testCanUseStringLikeCollection() {
        val s = "aBcD"
        assertEquals("BD", s.filter { it.isUpperCase() })
    }
}
