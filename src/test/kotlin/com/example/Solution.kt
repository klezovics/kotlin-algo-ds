package com.example

fun main() {
    val s = Solution()
    // println(s.lengthOfLongestSubstring("tmmzuxt"))
}

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return Board(board).isValid()
    }

    class Board(
        val board: Array<CharArray>
    ) {

        fun isValid(): Boolean {
            return allRowsValid() && allColumnsValid() && allSquaresValid()
        }

        fun allRowsValid(): Boolean {
            for (r in 0..8) {
                if (!rowValid(r)) return false
            }

            return true
        }

        fun allColumnsValid(): Boolean {
            for (c in 0..8) {
                if (!columnValid(c)) return false
            }

            return true
        }

        private fun rowValid(r: Int): Boolean {
            val s = mutableSetOf<Int>()
            for (c in 0..8) {
                val e = board[r][c]
                if (e == '.') continue
                if (s.contains(e.digitToInt())) return false
                s.add(e.digitToInt())
            }

            return true
        }

        private fun columnValid(c: Int): Boolean {
            val s = mutableSetOf<Int>()
            for (r in 0..8) {
                val e = board[r][c]
                if (e == '.') continue
                if (s.contains(e.digitToInt())) return false
                s.add(e.digitToInt())
            }

            return true
        }

        fun allSquaresValid(): Boolean {

            val squares = listOf(
                Pair(Pair(0, 0), Pair(2, 2)), // top left
                Pair(Pair(0, 3), Pair(2, 5)), // top mid
                Pair(Pair(0, 6), Pair(2, 8)), // top right 
                Pair(Pair(3, 0), Pair(5, 2)), // mid left
                Pair(Pair(3, 3), Pair(5, 5)), // mid mid
                Pair(Pair(3, 6), Pair(5, 8)), // mid right 
                Pair(Pair(6, 0), Pair(8, 2)), // bottom left
                Pair(Pair(6, 3), Pair(8, 5)), // bottom mid
                Pair(Pair(6, 6), Pair(8, 8)) // bottom right
            )
            for (square in squares) {
                if (!squareValid(square)) return false
            }

            return false
        }

        private fun squareValid(square: Pair<Pair<Int, Int>, Pair<Int, Int>>): Boolean {
            return true
        }
    }
}
