/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var left: ListNode? = dummy
        var right: ListNode? = dummy
        
        for (i in 0..n) {
            right = right?.next
        }
        
        while (right != null) {
            right = right.next
            left = left!!.next
        }
        
        left!!.next = left.next?.next
        return dummy.next
    }
}
