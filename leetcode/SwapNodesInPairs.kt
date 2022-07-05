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
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        
        val root = ListNode(-1)
        
        var prev = root
        var mid = head
        var next = head.next
        
        prev.next = mid
        
        while (mid != null && next != null) {
            swap (mid, next)
            prev.next = next
            
            prev = mid
            mid = prev.next
            next = mid?.next
        }
        
        return root.next
    }
    
    fun swap(mid: ListNode, next: ListNode) {
        val tmp = next.next
        next.next = mid
        mid.next = tmp
    }
}
