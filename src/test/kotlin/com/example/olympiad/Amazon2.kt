package com.example.olympiad

import java.util.Collections
import java.util.PriorityQueue

fun main(args: Array<String>) {
    println(getTotalImbalance(arrayOf(1, 2, 3)))
}

fun getTotalImbalance(weight: Array<Int>): Long {

    var total = 0L
    var curMin = Int.MAX_VALUE
    var curMax = Int.MIN_VALUE

    var pqMin = PriorityQueue<Int>()
    var pqMax = PriorityQueue<Int>(Collections.reverseOrder())

    for (p1 in 0 until weight.size) {
        curMin = weight[p1]
        curMax = weight[p1]
        for (p2 in p1 until weight.size) {
            var curElem = weight[p2]

            if (curElem > curMax) {
                curMax = curElem
            }
            if (curElem < curMin) {
                curMin = curElem
            }

            total += (curMax - curMin)
        }
    }

    return total
}
