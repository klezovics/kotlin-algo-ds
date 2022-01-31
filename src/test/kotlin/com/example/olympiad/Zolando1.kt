package com.example.olympiad

fun main() {
    println(extractSingleAnagrams(mutableSetOf()))
    println(extractSingleAnagrams(mutableSetOf("a")))
    println(extractSingleAnagrams(mutableSetOf("ab","ba")))
    println(extractSingleAnagrams(mutableSetOf("a","aa")))
}

// "abc" -> [a->1, b->1, c->1]
//

fun extractSingleAnagrams(strs: Set<String>): Set<String> {
    // Check if its "signature" is already in the target set
    var result = mutableSetOf<String>()
    var charCountMaps = mutableSetOf<Map<Char, Int>>()

    for (str in strs) {
        var charCountMap = toCharCountMap(str)
        if (!charCountMaps.contains(charCountMap)) {
            charCountMaps.add(charCountMap)
            result.add(str)
        }
    }

    return result
}

fun toCharCountMap(str: String): Map<Char, Int> {
    val charCountMap = mutableMapOf<Char, Int>()
    for (c in str) {
        if (charCountMap.contains(c)) {
            val curCount = charCountMap.get(c)!!
            charCountMap.put(c, curCount + 1)
        } else {
            charCountMap.put(c, 1)
        }
    }

    return charCountMap
}
