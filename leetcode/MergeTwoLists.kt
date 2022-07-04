/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {        
        var l1 = list1
        var l2 = list2
        
        if (l1 == null || (l2 != null && l1.`val` > l2.`val`)) {
            val tmp = l1
            l1 = l2
            l2 = tmp
        }
        
        if (l1 != null) {
            l1.next = mergeTwoLists(l1.next, l2)
        }
        
        return l1
    }
}
