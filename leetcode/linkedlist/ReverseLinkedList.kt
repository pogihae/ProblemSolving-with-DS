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
  fun reverseList(head: ListNode?): ListNode? {
    fun reverse(cur: ListNode?, prev: ListNode? = null): ListNode? {
      if (cur == null) return prev
      
      val next = cur.next
      cur.next = prev
      
      return reverse(next, cur)
    }
    
    return reverse(head)
  }
}
//kotlin default value in parameter must place in end of args
//non-recursive
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        val reversedRoot = ListNode(-1)
        
        var cur = head
        while (cur != null) {
            val tmp = cur.next
            cur.next = reversedRoot.next
            reversedRoot.next = cur
            cur = tmp
        }
        
        return reversedRoot.next
    }
}
