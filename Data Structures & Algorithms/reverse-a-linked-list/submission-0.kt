/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        var currentNode = head
        var previousNode: ListNode? = null

        while (currentNode!!.next != null) {
            val newPreviousNode = currentNode
            currentNode = currentNode.next
            if (newPreviousNode == head) {
                newPreviousNode.next = null
            } else {
                newPreviousNode.next = previousNode
            }
            previousNode = newPreviousNode
        }
        
        currentNode.next = previousNode // after the loop, currentNode is tail so just update its 'next'

        return currentNode
    }
}
