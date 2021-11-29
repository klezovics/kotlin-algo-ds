package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinQueue {

    @Test
    fun testCanUseDequeAsQueue() {
        val queue = ArrayDeque<Int>()

        // Add items (enqueue)
        queue.add(1)
        queue.add(2)
        queue.add(3)
        queue.add(4)

        assertEquals(1, queue.removeFirst())
        assertEquals(2, queue.removeFirst())
        assertEquals(3, queue.removeFirst())
        assertEquals(4, queue.removeFirst())
    }

    @Test
    fun testCanAddRemoveItemsFromBothSidesOfDeque() {
        val queue = ArrayDeque<Int>()

        queue.addLast(1)
        queue.addLast(2)
        queue.addFirst(0)

        assertEquals(0, queue.removeFirst())
        assertEquals(1, queue.removeFirst())
        assertEquals(2, queue.removeFirst())
    }
}
