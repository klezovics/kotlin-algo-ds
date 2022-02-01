package com.example.google.linkedlist

import org.junit.jupiter.api.Test

class LinkedListTests {

    @Test
    fun testCanDetectCycle() {
        println(hasCycle(withCycle()))
        println(hasCycle(noCycle()))
    }

    @Test
    fun testCanReverse() {
        val ll = noCycle()

        var current: Node? = ll
        var newHead: Node? = null
        while (current != null) {
            val newNode = Node(current.key)
            if(newHead == null) newHead = newNode
            else {
                newNode.next = newHead
                newHead = newNode
            }
            current = current.next
        }

        var newCurrent: Node? = newHead
        while (newCurrent != null) {
            println(newCurrent.key)
            newCurrent = newCurrent.next
        }
    }

    fun hasCycle(node: Node): Boolean {
        var slow = node
        var fast = node
        while (slow.next != null && fast.next != null && fast.next!!.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
            if (fast == slow) return true
        }

        return false
    }

    fun withCycle(): Node {
        val n1 = Node(1)
        val n2 = Node(2)
        val n3 = Node(3)
        val n4 = Node(4)

        n1.next = n2
        n2.next = n3
        n3.next = n4
        n4.next = n1

        return n1
    }

    fun noCycle(): Node {
        val n1 = Node(1)
        val n2 = Node(2)
        val n3 = Node(3)
        val n4 = Node(4)

        n1.next = n2
        n2.next = n3
        n3.next = n4

        return n1
    }
}

data class Node(
    val key: Int
) {
    var next: Node? = null
}
