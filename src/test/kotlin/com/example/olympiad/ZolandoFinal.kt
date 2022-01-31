package com.example.olympiad

import java.time.Instant

fun main() {
    println("Hello, Zolando")
}
/*
TEST CASES

1) Basic valid case
push
u1 approval
u2 approval
-> true

2) Push after aprival invalidates approval
u1 approval
u2 approval
push
-> false

3) 0 approvals -> false
push
-> false

4) 1 approval -> false
push
u1 approval

5) Comments do not change approval status
push
u1 comment
u2 comment
-> false

6) More advanced pass case
u1 comment
u2 comment
push
u1 approval
u2 approval
-> true

push
u1 rejection
u1 approval
u2 approval
-> true

push
u1 rejection
u2 approval
u3 approval
u1 comment
-> false

push
u1 rejection
u2 approval
u1 rejection
u1 approval
-> true

*/



/*
Logical solution
*/

enum class CommentType {
    COMMENT, APPROVAL, REJECTION
}

data class Comment(
    val timestamp: Instant,
    val text: String,
    val type: CommentType,
    val userId: Long
)

// O(n*log(n)) -> runtime
// O(n) -> memory consumption
// User can reject a pull request
// If even a single rejection is in comments - then reject PR
fun isPrInValidApprovalState(lastCommitTimestamp: Instant, comments: List<Comment>): Boolean {

    // Check if PR is rejected
    var rejections = comments.filter { it.type == CommentType.REJECTION }.toMutableSet()


    // Remove all non-approval comments
    val approvals = comments.filter { it.type == CommentType.APPROVAL }

    if(approvals.size < 2) return false
    approvals.sortedByDescending { it.timestamp }

    val approvers = mutableSetOf<Long>()

    for( approval in approvals ) {
        if( approval.timestamp.isAfter(lastCommitTimestamp)) {
            approvers.add(approval.userId)

            //Invalidate rejections
            rejections.removeIf{ it.timestamp.isBefore(approval.timestamp) && it.userId == approval.userId }

        }

        if(approvers.size >= 2 && rejections.isEmpty()) return true
    }

    return false
}


