/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var list1Curr = list1
        var list2Curr = list2

        while (list1Curr != null && list2Curr != null) {
            if (list1Curr.`val` < list2Curr.`val`) {
                tail.next = list1Curr
                list1Curr = list1Curr.next
            } else {
                tail.next = list2Curr
                list2Curr = list2Curr.next
            }
 
            tail = tail.next!!
        }

        if (list1Curr != null) {
            tail.next = list1Curr
        } else if (list2Curr != null) {
            tail.next = list2Curr
        }

        return dummy.next
    }
}
