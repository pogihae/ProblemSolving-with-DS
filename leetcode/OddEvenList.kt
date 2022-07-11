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
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        
        var oddTail = head
        
        val evenHead = head.next
        var evenTail = evenHead
        
        var tmp = head.next.next
        evenTail.next = null
      
        var isOdd = true
        
        while (tmp != null) {
            val nextTmp = tmp.next
            
            if (isOdd) {
                oddTail!!.next = tmp
                oddTail = tmp
            }
            else {
                evenTail!!.next = tmp
                evenTail = tmp
            }
            
            tmp.next = null
            isOdd = !isOdd
            tmp = nextTmp
        }
        
        oddTail!!.next = evenHead
        
        return head
    }
}
