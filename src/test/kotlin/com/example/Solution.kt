package com.example

fun main() {
    println(Solution().minPartitions("9"))
    println(Solution().minPartitions("32"))
}

class Solution {
    fun minPartitions(n: String): Int {
        var requiredOnes = mutableListOf<Int>()
        n.forEach { requiredOnes.add( it.digitToInt()) }

        var numCount = 0
        // Keep adding numbers until all requirements are satisfied
        while (requiredOnes.any {it != 0}) {
            var toAdd = requiredOnes.count { it != 0 }
            numCount++
            requiredOnes = requiredOnes.map { if(it==0) 0 else it-1 }.toMutableList()
        }

        return numCount
    }
}
