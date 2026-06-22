/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var newListHead: ListNode? = null
        var newListPrev: ListNode? = null
        var list1Curr = list1
        var list2Curr = list2

        while (list1Curr != null || list2Curr != null) {
            val shouldInsertList1El =
                list2Curr == null || (list1Curr != null && list1Curr.`val` <= list2Curr.`val`)

            if (shouldInsertList1El) {
                val newNode = ListNode(list1Curr!!.`val`)
                if (newListPrev != null) {
                    newListPrev.next = newNode
                } else {
                    newListHead = newNode
                }
                newListPrev = newNode
                list1Curr = list1Curr.next
            } else {
                val newNode = ListNode(list2Curr!!.`val`)
                if (newListPrev != null) {
                    newListPrev.next = newNode
                } else {
                    newListHead = newNode
                }
                newListPrev = newNode
                list2Curr = list2Curr.next
            }
        }

        return newListHead
    }
}
