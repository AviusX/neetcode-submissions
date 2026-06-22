import java.math.BigInteger

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        when {
            l1 == null && l2 != null -> return l2
            l2 == null && l1 != null -> return l1
            l1 == null && l2 == null -> return null
        }

        val dummy = ListNode(0)
        var l1Curr = l1
        var l2Curr = l2
        var currentNode = dummy
        var carry = 0

        while (l1Curr != null || l2Curr != null || carry != 0) {
            val x = l1Curr?.`val` ?: 0
            val y = l2Curr?.`val` ?: 0
            val sum = x + y + carry

            carry = if (sum > 9) sum / 10 else 0
            currentNode.next = ListNode(sum % 10)
            currentNode = currentNode.next!!

            l1Curr = l1Curr?.next
            l2Curr = l2Curr?.next
        }

        return dummy.next
    }
}
