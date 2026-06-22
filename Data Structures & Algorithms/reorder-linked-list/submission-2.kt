/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head.next == null) return

        var slow = head
        var fast = head.next

        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }

        val secondHalfHead = slow!!.next
        slow.next = null

        val reversedMidHead = reverseLinkedList(secondHalfHead)
        mergeLists(head, reversedMidHead!!)
    }

    private fun reverseLinkedList(head: ListNode?): ListNode? {
        var previousNode: ListNode? = null
        var currentNode = head

        while (currentNode != null) {
            val nextNode = currentNode.next
            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = nextNode
        }

        return previousNode
    }

    private fun mergeLists(firstHead: ListNode, secondHead: ListNode) {
        var curr1: ListNode? = firstHead
        var curr2: ListNode? = secondHead

        while(curr2 != null) {
            val firstListNext = curr1!!.next
            val secondListNext = curr2.next
            curr1.next = curr2
            curr2.next = firstListNext
            curr1 = firstListNext
            curr2 = secondListNext
        }
    }
}
