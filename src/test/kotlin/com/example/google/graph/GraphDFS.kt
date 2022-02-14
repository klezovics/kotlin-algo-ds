package com.example.google.graph

import org.junit.jupiter.api.Test
import java.util.LinkedList

class GraphDFS {

    @Test
    fun testBasicDfs() {
        // 0->1->2->3
        val r = bfs(
            listOf(
                listOf(1),
                listOf(2),
                listOf(3),
                listOf()
            )
        )

        for ((count, component) in r.withIndex()) {
            print("Component $count:")
            component.forEach { print("$it,") }
            println()
        }
    }

    @Test
    fun testAdvancedDfs() {
        // 0 -> 1,2 
        // 1 -> 3,4
        // 2 -> 3,4
        // 5 -> 6
        val r = bfs(
            listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(3, 4),
                listOf(),
                listOf(),
                listOf(5, 6),
                listOf()
            )
        )

        for ((count, component) in r.withIndex()) {
            print("Component $count:")
            component.forEach { print("$it,") }
            println()
        }
    }

    // I1: Receive graph as adjacency list
    // I2: Return traversal as a traversal of a set of connected components
    fun bfs(nodes: List<List<Int>>): List<List<Int>> {
        // I3: Keep track of list of visited nodes
        val visited = BooleanArray(nodes.size) { false }

        val result = LinkedList<MutableList<Int>>()

        // We will try to start the process for every unvisited node
        // This is because they might be distributed several connected components
        for (node in 0 until nodes.size) {
            // If we visited a node in a previous component -> skip it
            if (visited[node]) continue

            // Q -> Next to visit
            val q = LinkedList<Int>()
            q.add(node)
            result.add(mutableListOf<Int>())

            // Q may contain duplicate nodes, since two nodes
            // processed in sequence can have the same neighbour
            while (q.isNotEmpty()) {
                val current = q.poll()
                // Check if we've been here before
                if (visited[current]) continue
                // Visiting a node occurs here
                visited[current] = true
                result.last.add(current)
                println("Touching $current")

                // Let's load its neighbours into a queue
                for (neighbour in nodes[current]) {
                    // We don't want duplicate visits
                    if (!visited[neighbour]) q.add(neighbour)
                }
            }
        }
        return result
    }
}
