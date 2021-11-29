package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinStack {

    @Test
    fun testCanUseArrayDequeAsStack() {
        val stack = ArrayDeque<Int>()

        stack.addLast(0)
        stack.addLast(1)
        stack.addLast(2)
        stack.addLast(3)

        assertEquals(3, stack.removeLast())
        assertEquals(2, stack.removeLast())
        assertEquals(1, stack.removeLast())
        assertEquals(0, stack.removeLast())
    }
}
