package com.example.olympiad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

fun main() {
    println("Test run")
    assertFalse(areIntersecting(0,1,2,3))
    assertFalse(areIntersecting(2,3,0,1))

    // A covers B
    assertTrue(areIntersecting(0,10,1,2))
    // B covers A
    assertTrue(areIntersecting(1,5, 1,10))

    // A left overlap with B
    assertTrue(areIntersecting(0,2,1,2))
    // A right overlap with B
    assertTrue(areIntersecting(4,10, 2,5))
}

/*
      [0,1] [2,3] -> false
      [0,2] [1,3] -> true

      a strictly left of b
      a strictly right of b
      a covers b
      b covers a


 */
fun areIntersecting(x1: Int, y1:Int, x2:Int, y2:Int): Boolean {
    require(x1<=y1)
    require(x2<=y2)

    // A is left of B
    if(y1 < x2) return false

    // A is right of B
    if(y2 < x1) return false

    return true
}
