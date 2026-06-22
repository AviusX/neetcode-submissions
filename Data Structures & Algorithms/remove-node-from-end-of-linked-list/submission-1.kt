/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        val listSize = getListSize(head)
        
        if (head.next == null && n == 1) {
            return null
        } else if (n == listSize) {
            return head.next
        }

        var currentNode = head
        var previousNode: ListNode? = null

        for (i in 0..<listSize - n) {
            previousNode = currentNode
            currentNode = currentNode!!.next
        }

        if (previousNode == null) {
            return currentNode // currentNode is the new head
        } else {
            previousNode.next = currentNode?.next
            return head
        }
    }

    private fun getListSize(head: ListNode): Int {
        var size = 0
        var currNode: ListNode? = head

        while (currNode != null) {
            size++
            currNode = currNode.next
        }

        return size
    }
}
