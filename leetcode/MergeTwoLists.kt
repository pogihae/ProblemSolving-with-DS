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

//non-recursive
class Solution2 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        
        val mergedRoot = ListNode(-1)
        var cur = mergedRoot
        
        var p1 = list1
        var p2 = list2
        
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2
                p2 = p2!!.next
            } else if (p2 == null) {
                cur.next = p1
                p1 = p1!!.next
            } else if (p1.`val` > p2.`val`) {
                cur.next = p2
                p2 = p2.next
            } else {
                cur.next = p1
                p1 = p1.next
            }
            
            cur = cur.next
        }
        
        return mergedRoot.next
    }
}
