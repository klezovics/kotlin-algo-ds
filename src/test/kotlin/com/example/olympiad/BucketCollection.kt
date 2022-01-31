package com.example.olympiad

import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.TreeSet

// Case 1 - Collection of dots with the same value -> must go into the same bucket
// Case 2 - Cluster of dots around a specific value -> 00:00, 00:01, ..., 00:15 ... 00:29 | 00:30 -> cluster
// Case 3 - Two clusters 00:15 and 00:30
// Case 4 - Multiple clusters with some values evenly distributed
// Case 5 - Lowest possible timestamps value, highest possible timestamp value
// Case 6 - Overlaps ...


fun main() {
    var bc = BucketCollection()
    bc.put(Instant.now())
    bc.put(Instant.now().plus(1, ChronoUnit.MINUTES))

    bc.put(Instant.now().plus(2, ChronoUnit.HOURS))
    bc.put(Instant.now().plus(121, ChronoUnit.MINUTES))

    println(bc.bucketSet)
}

class BucketCollection {

    var bucketSet: MutableSet<Bucket> = TreeSet<Bucket>()

    fun put(t: Instant) {
        val targetBucket = bucketSet.find { it.startTime!! <= t && t <= it.endTime!! }
        if (targetBucket == null) {
            // Bucket not found create new one
            var newBucket = Bucket()
            newBucket.startTime = t.minus(15, ChronoUnit.MINUTES)
            newBucket.endTime = t.plus(15, ChronoUnit.MINUTES)
            bucketSet.add(newBucket)
            newBucket.timestamps.add(t)
        } else {
            // Added element to the bucket
            targetBucket.timestamps.add(t)
        }
    }

    fun getBuckets(): MutableSet<Bucket> {
        return bucketSet
    }
}

class Bucket : Comparable<Bucket> {

    var startTime: Instant? = null
    var endTime: Instant? = null
    var timestamps: MutableSet<Instant> = mutableSetOf()
    override fun compareTo(other: Bucket): Int {
        if(startTime!!.isBefore(other.startTime)) return -1
        if(startTime!!.isAfter(other.startTime)) return 1

        return 0
    }
}
