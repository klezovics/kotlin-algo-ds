package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Collections
import java.util.PriorityQueue

class KotlinPriorityQueue {

    @Test
    fun testCanUseJavaMinPriorityQueue() {
        val queue: PriorityQueue<Int> = PriorityQueue<Int>()

        // Add items (enqueue)
        queue.add(800)
        queue.add(50)
        queue.add(200)
        queue.add(550)

        assertEquals(50, queue.poll())
        assertEquals(200, queue.poll())
        assertEquals(550, queue.poll())
        assertEquals(800, queue.poll())
    }

    @Test
    fun testCanUseJavaMaxPriorityQueue() {
        val queue: PriorityQueue<Int> = PriorityQueue<Int>(Collections.reverseOrder())

        // Add items (enqueue)
        queue.add(800)
        queue.add(50)
        queue.add(200)
        queue.add(550)

        assertEquals(800, queue.poll())
        assertEquals(550, queue.poll())
        assertEquals(200, queue.poll())
        assertEquals(50, queue.poll())
    }
}
