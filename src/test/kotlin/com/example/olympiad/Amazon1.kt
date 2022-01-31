package com.example.olympiad

fun main(args: Array<String>) {
    println(countDecreasingRatings(arrayOf(4, 3, 5, 4, 3)))
}

fun countDecreasingRatings(ratings: Array<Int>): Long {
    if (ratings.size == 0) return 0
    if (ratings.size == 1) return 1

    var total: Long = 0
    var maxLens = mutableListOf<Int>()

    var pStart = 0
    var pEnd = 1

    var gotMatch = false

    while (pEnd < ratings.size) {
        if (ratings[pEnd - 1] - ratings[pEnd] == 1) {

            if (gotMatch == false) {
                gotMatch = true
            }
            println("Continue to grow $pStart:$pEnd")

            pEnd++
        } else {
            // Reached the end of the good part of array
            if (gotMatch) {
                var goodEnd = pEnd - 1
                maxLens.add(goodEnd - pStart + 1)
                println("$pStart:$goodEnd")
            }

            pStart = pEnd
            pEnd = pStart + 1
            gotMatch = false
        }
    }

    if (gotMatch) {
        maxLens.add(pEnd - pStart)
    }

    for (len in maxLens) {
        // Count all subarrays, but not those which have length 1
        println("max len $len")
        total += ((len) * (len + 1) / 2)
    }

    var lenSum = 0


    return total
}
