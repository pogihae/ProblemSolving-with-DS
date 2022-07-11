class Solution {
    fun removeDuplicateLetters(s: String): String {
        val counter = IntArray(26)
        for (c in s) {
            counter[c-'a'] += 1
        }
        
        val seen = BooleanArray(26)
        val stack = Stack<Char>()
        
        for (c in s) {
            counter[c-'a'] -= 1
            if (seen[c - 'a']) continue
            
            while (stack.isNotEmpty() && c < stack.peek() && counter[stack.peek() - 'a'] > 0) {
                seen[stack.pop() - 'a'] = false
            }
            
            stack.add(c)
            seen[c - 'a'] = true
        }
        
        return stack.joinToString("")
    }
}
