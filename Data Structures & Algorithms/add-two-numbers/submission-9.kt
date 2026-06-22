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

        var l1Curr = l1
        var l2Curr = l2
        val dummy = ListNode(0)
        var currentNode = dummy
        var carry = 0

        while (l1Curr != null && l2Curr != null) {
            val sum = l1Curr.`val` + l2Curr.`val` + carry
            carry = if (sum > 9) sum / 10 else 0
            currentNode.next = ListNode(sum % 10)
            currentNode = currentNode.next!!
            l1Curr = l1Curr.next
            l2Curr = l2Curr.next
        }

        while (l1Curr != null) {
            val sum = if (carry != 0) carry + l1Curr.`val` else l1Curr.`val`
            carry = if (sum > 9) sum / 10 else 0
            currentNode.next = ListNode(sum % 10)
            currentNode = currentNode.next!!
            l1Curr = l1Curr.next
        }

        while (l2Curr != null) {
            val sum = if (carry != 0) carry + l2Curr.`val` else l2Curr.`val`
            carry = if (sum > 9) sum / 10 else 0
            currentNode.next = ListNode(sum % 10)
            currentNode = currentNode.next!!
            l2Curr = l2Curr.next
        }

        if (carry != 0) {
            currentNode.next = ListNode(carry)
        }

        return dummy.next
    }
}
