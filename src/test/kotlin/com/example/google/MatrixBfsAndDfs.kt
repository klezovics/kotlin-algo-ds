package com.example.google

import org.junit.jupiter.api.Test

class MatrixBfsAndDfs {

    @Test
    fun doMatrixBfs() {
        doBfs(get5by5Matrix()).forEach {
            println(it)
        }
    }

    @Test
    fun doMatrixDfs() {
        doDfs(get5by5Matrix()).forEach {
            println(it)
        }
    }

    fun doDfs(m: Array<IntArray>): List<Int> {
        val visited = mutableListOf<BooleanArray>()
        m.forEach {
            visited.add(BooleanArray(m[0].size) { false })
        }

        val traversal = mutableListOf<Int>()
        dfs(row = 0, col = 0, m = m, visited = visited.toTypedArray(), traversal = traversal)
        return traversal
    }

    fun dfs(
        row: Int,
        col: Int,
        m: Array<IntArray>,
        visited: Array<BooleanArray>,
        traversal: MutableList<Int>
    ) {
        if (row < 0) return
        if (col < 0) return
        if (row >= m[0].size) return
        if (col >= m.size) return
        if (visited[row][col]) return

        val directions = listOf(
            intArrayOf(-1, 0), // up
            intArrayOf(0, 1), // right
            intArrayOf(1, 0), // down
            intArrayOf(0, -1) // left
        )

        visited[row][col] = true
        traversal.add(m[row][col])

        for (ii in 0 until directions.size) {
            val nX = row + directions[ii][0]
            val nY = col + directions[ii][1]
            dfs(row = nX, col = nY, m = m, visited = visited, traversal = traversal)
        }
    }

    fun doBfs(m: Array<IntArray>): List<Int> {
        return mutableListOf()
    }

    fun get5by5Matrix(): Array<IntArray> {
        val m = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25)
        )

        return m
    }
}
