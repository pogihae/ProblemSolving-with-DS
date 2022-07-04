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
