package com.example.google

import org.junit.jupiter.api.Test
import java.util.LinkedList

class TreeBfsAndDfs {

    @Test
    fun doTreeBfs() {
        bfs(getBasicTree()).forEach {
            println(it)
        }
    }

    @Test
    fun doTreeDfs() {
        dfs(getBasicTree()).forEach {
            println(it)
        }
    }

    fun bfs(root: Node?): List<Int> {
        if (root == null) return mutableListOf()
        val q = LinkedList<Node>()

        q.add(root)
        val traversal = mutableListOf<Int>()
        while (!q.isEmpty()) {
            val current = q.poll()
            traversal.add(current.value)

            if (current.left != null) q.add(current.left!!)
            if (current.right != null) q.add(current.right!!)
        }

        return traversal
    }

    fun dfs(root: Node?): List<Int> {
        if (root == null) return mutableListOf()
        val q = LinkedList<Node>()

        q.push(root)
        val traversal = mutableListOf<Int>()
        while (!q.isEmpty()) {
            val current = q.pop()
            traversal.add(current.value)

            if (current.right != null) q.push(current.right!!)
            if (current.left != null) q.push(current.left!!)
        }

        return traversal
    }

    /*
        Tree is
            0
          1   2
        3  4 5  6
     */
    fun getBasicTree(): Node {
        val nodes = mutableListOf<Node>()
        for (ii in 0..6) {
            nodes.add(Node(ii))
        }

        nodes[0].left = nodes[1]
        nodes[0].right = nodes[2]

        nodes[1].left = nodes[3]
        nodes[1].right = nodes[4]

        nodes[2].left = nodes[5]
        nodes[2].right = nodes[6]

        return nodes[0]
    }
}

data class Node(
    val value: Int
) {
    var left: Node? = null
    var right: Node? = null
}
