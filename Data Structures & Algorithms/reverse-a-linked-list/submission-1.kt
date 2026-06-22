/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
        fun reverseList(head: ListNode?): ListNode? {
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
}
