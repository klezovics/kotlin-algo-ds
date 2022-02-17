package com.example.sandbox

import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class OddEvenSortTest {

    @Test
    fun testCanSortOddEven() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        oddEvenMerge(nums).forEach { print("$it,") }
    }

    @Test
    fun testMergeStep() {
        val n1 = intArrayOf(1, 2)
        val n2 = intArrayOf(3, 4)
        merge(n1, n2).forEach { print("$it,") }
    }

    fun oddEvenMerge(nums: IntArray): IntArray {
        if (nums.size <= 1) return nums

        val mid = nums.size / 2

        // l=1 mid=2 r=3 -> 0
        val leftSorted = oddEvenMerge(nums.copyOfRange(0, mid))
        val rightSorted = oddEvenMerge(nums.copyOfRange(mid, nums.size))

        return merge(leftSorted, rightSorted)
    }

    fun merge(n1: IntArray, n2: IntArray): IntArray {
        val merged = IntArray(n1.size + n2.size) { -1 }

        val oddEvenCompare: (Int, Int) -> Int = fun(one, two): Int {
            val oneEven = if (one % 2 == 0) true else false
            val twoEven = if (two % 2 == 0) true else false

            if (oneEven && twoEven) return 0
            else if (!oneEven && !twoEven) return 0
            else if (oneEven && !twoEven) return 1

            return -1
        }
        // Need to implement custom comparator for pq
        val q1 = PriorityQueue<Int>(oddEvenCompare)
        q1.addAll(n1.toList())
        val q2 = PriorityQueue<Int>(oddEvenCompare)
        q2.addAll(n2.toList())

        var ii = 0
        while (q1.isNotEmpty() && q2.isNotEmpty()) {
            val c1 = q1.peek()
            val c2 = q2.peek()

            if (oddEvenCompare(c1, c2) == 0) {
                merged[ii] = q1.poll()
                ii++
                merged[ii] = q2.poll()
                ii++
                continue
            }

            // C1 is odd, C2 is odd
            if (oddEvenCompare(c1, c2) == -1) {
                merged[ii] = q1.poll()
                ii++
            }

            if (oddEvenCompare(c1, c2) == 1) {
                merged[ii] = q2.poll()
                ii++
            }
        }

        while (q1.isNotEmpty()) {
            merged[ii] = q1.poll(); ii++
        }

        while (q2.isNotEmpty()) {
            merged[ii] = q2.poll(); ii++
        }

        return merged
    }

    fun oddEven(nums: IntArray): IntArray {

        var hasDisorder = true
        while (hasDisorder) {
            hasDisorder = false
            for (ii in 1 until nums.size) {
                // If even is in front of odd -> swap
                if (nums[ii] % 2 != 0 && nums[ii - 1] % 2 == 0) {
                    val tmp = nums[ii]
                    nums[ii] = nums[ii - 1]
                    nums[ii - 1] = tmp
                    hasDisorder = true
                }
            }
        }

        return nums
    }

    fun oddEven0(nums: IntArray): IntArray {
        val odds = nums.filter { it % 2 != 0 }
        val evens = nums.filter { it % 2 == 0 }

        var ii = 0
        for (n in odds) {
            nums[ii] = n
            ii++
        }

        for (n in evens) {
            nums[ii] = n
            ii++
        }

        return nums
    }
}
