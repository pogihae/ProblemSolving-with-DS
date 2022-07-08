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
    fun isPalindrome(head: ListNode?): Boolean {
        val list = ArrayDeque<Int>()
        
        var curNode = head
        while (curNode != null) {
            list += curNode.`val`
            curNode = curNode.next
        }
        
        while (list.size > 1) {
            if (list.removeFirst() != list.removeLast()) return false
        }
        
        return true
    }
}

//fast, slow runner

class Solution2 {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return false
        if (head.next == null) return true
        
        val reversedListRoot = ListNode(-1)
        
        var slow = head
        var fast = head
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next
            
            val tmp = slow!!.next
            slow!!.next = reversedListRoot.next
            reversedListRoot.next = slow
            slow = tmp
        }
        
        if (fast != null) slow = slow!!.next
        
        var reversed = reversedListRoot.next 
        
        while (slow != null && reversed != null) {
            if (slow.`val` != reversed.`val`) {
                return false
            }
            slow = slow.next
            reversed = reversed.next
        }
        
        return true
    }
}
