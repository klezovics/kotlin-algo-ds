package com.example.google

import org.junit.jupiter.api.Test

class MatrixBfsAndDfs {

    @Test
    fun doMatrixBfs() {
        doDfs(get5by5Matrix()).forEach {
            println(it)
        }
    }

    @Test
    fun doMatrixDfs() {
        doBfs(get5by5Matrix()).forEach {
            println(it)
        }
    }

    fun doDfs(m: Array<IntArray>): List<Int> {
        return mutableListOf()
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
