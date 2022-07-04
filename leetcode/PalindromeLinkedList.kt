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
