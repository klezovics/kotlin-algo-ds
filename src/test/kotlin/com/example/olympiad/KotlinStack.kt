package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Stack

class KotlinStack {

    @Test
    fun testCanUseJavaStack() {
        var stack = Stack<Int>()

        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }

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
