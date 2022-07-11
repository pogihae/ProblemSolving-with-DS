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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val answer = ListNode(-1)
        
        val modDiv = { n: Int -> n % 10 to n / 10 }
        
        var cur1 = l1
        var cur2 = l2
        
        var temp = answer
        var carry = 0
        
        while (!(cur1 == null && cur2 == null) || carry != 0) {
            val n1 = if (cur1 == null) 0 else cur1.`val`
            val n2 = if (cur2 == null) 0 else cur2.`val`
            
            val (mod, div) = modDiv(n1 + n2 + carry)
            
            temp.next = ListNode(mod)
            temp = temp.next
            
            cur1 = cur1?.next
            cur2 = cur2?.next
            
            carry = div
        }
        
        return answer.next
    }
}

//local funtion, val function
//Stack.pop() when isEmpty, return Exception

class Solution2 {
    val ListNode?.value
        get() = this?.`val` ?: 0
    
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val root = ListNode(-1)
        var cur = root
        
        var p1 = l1
        var p2 = l2
        
        var carry = 0
        while (p1 != null || p2 != null || carry != 0) {
            val sum = p1.value + p2.value + carry
            
            carry = sum / 10
            
            cur.next = ListNode(sum % 10)
            
            p1 = p1?.next
            p2 = p2?.next
            cur = cur.next
        }
        
        return root.next
    }
}
