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

        val l1Num = convertLinkedListToNumber(l1!!)
        val l2Num = convertLinkedListToNumber(l2!!)

        return convertNumberToLinkedList(l1Num + l2Num)
    }

    private fun convertLinkedListToNumber(head: ListNode): BigInteger {
        var multiplier = 1.toBigInteger()
        var result = 0.toBigInteger()
        var currentNode: ListNode? = head

        while (currentNode != null) {
            result += currentNode.`val`.toBigInteger() * multiplier
            multiplier *= 10.toBigInteger()
            currentNode = currentNode.next
        }

        return result
    }

    private fun convertNumberToLinkedList(num: BigInteger): ListNode {
        if (num == 0.toBigInteger()) return ListNode(0)

        var result = num
        val dummy = ListNode(0)
        var currentNode = dummy

        while (result != 0.toBigInteger()) {
            currentNode.next = ListNode((result % 10.toBigInteger()).toInt())
            result /= 10.toBigInteger()
            currentNode = currentNode.next!!
        }

        return dummy.next!!
    }
}
