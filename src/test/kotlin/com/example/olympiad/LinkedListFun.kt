package com.example.olympiad

import com.example.olympiad.LinkedListFun.*
import org.junit.jupiter.api.Test

// OK, so here's how the problem sequence goes
// 1) Create a single linked list node ++
// 2) Create a linked list with 2 nodes ++
// 3) Create a linked list with N nodes ++
// 4) Get Nth node from a linked list ++
// 5) Get nodes N to N+K in from a linked list ++
// 6) Reverse a linked list
// 7) Reverse a sublist of a linked list
// 8) Detect a linked list cycle. Detect cycle start node

class LinkedListFun {

    data class Node(
        var `val`: Int,
        var next: Node?
    )

    @Test
    fun testCanCreateLinkedList() {
        val n1 = Node(1, null)
        val n2 = Node(2, null)

        n1.next = n2

        val head = n1
        var currentNode: Node? = head
        while (currentNode != null) {
            print("${currentNode.`val`}->")
            currentNode = currentNode.next
        }
    }

    @Test
    fun testCanCreateLongLinkedList() {
        printList(getLinkedList(0))
        printList(getLinkedList(1))
        printList(getLinkedList(2))
        printList(getLinkedList(5))
    }

    @Test
    fun testCanGetNthNode() {
        val head = getLinkedList(10)
        println(getKthNode(head, 0)!!.`val`)
        println(getKthNode(head, 1)!!.`val`)
        println(getKthNode(head, 7)!!.`val`)
        println(getKthNode(head, 500))
    }

    @Test
    fun testCanGetSublist() {
        val head = getLinkedList(10)
        printList(getSublist(head, 1, 5))
    }

    @Test
    fun testCanReverseList() {
        val head = getLinkedList(5)
        printList(reverse(head))
    }

    fun reverse(head: Node?): Node? {
        if (head == null) return null

        var newListHead: Node? = null
        var curNode = head

        while (curNode != null) {

            // Save pointer to the next node
            var tmp = curNode.next

            println("Cur node ${curNode.`val`}")
            if (newListHead == null) {
                // Take the head an turn it into a tail
                newListHead = curNode
                newListHead.next = null
            } else {
                // OK, point the current node to the head of the new list
                curNode.next = newListHead
                newListHead = curNode
            }

            curNode = tmp
        }

        return newListHead
    }

    fun getSublist(head: Node?, start: Int, end: Int): Node? {
        if (head == null) return null

        val startNode = getKthNode(head, start)

        // Create a copy of the head
        val newHead = startNode!!.copy()

        var curNodeIdx = start + 1
        var curNode = startNode.next
        var prevNode = newHead

        // Copy all the nodes between the head and tail
        while (curNodeIdx < end) {
            val nodeCopy = curNode!!.copy()
            prevNode.next = nodeCopy
            prevNode = nodeCopy
            curNode = curNode!!.next
            curNodeIdx++
        }

        // Copy the tails
        val tailCopy = curNode!!.copy()
        tailCopy.next = null
        prevNode.next = tailCopy

        return newHead
    }

    fun getKthNode(head: Node?, k: Int): Node? {
        var currentNode = head
        var currentNodeIndex = 0
        while (currentNode != null) {
            if (currentNodeIndex == k) return currentNode
            currentNode = currentNode.next
            currentNodeIndex++
        }

        return null
    }

    fun printList(head: Node?) {
        if (head == null) return
        var currentNode = head
        while (currentNode != null) {
            print("${currentNode.`val`}->")
            currentNode = currentNode.next
        }
        print("\n")
    }

    fun getLinkedList(size: Int): Node? {
        var prevNode: Node? = null
        var head: Node? = null
        for (ii in 0 until size) {
            val currentNode = Node(ii, null)
            if (prevNode != null) {
                prevNode.next = currentNode
            } else {
                head = currentNode
            }

            prevNode = currentNode
        }

        return head
    }
}
