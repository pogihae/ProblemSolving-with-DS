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
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val root = ListNode(-1)
        var prev = root
        
        var next = head
        for (i in 1 until left) {
            prev.next = next
            prev = prev.next
            next = next!!.next
        }
        
        val rvHead = ListNode(-1)
        var rvTail = next
        
        for (i in left..right) {
            val tmp = next!!.next
            next.next = rvHead.next
            rvHead.next = next
            next = tmp
        }
        
        rvTail!!.next = next
        prev.next = rvHead.next
        
        return root.next
    }
}
