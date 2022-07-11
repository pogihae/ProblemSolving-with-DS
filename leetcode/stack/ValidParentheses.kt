class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        
        val blacketMap = mapOf(
            '{' to '}',
            '(' to ')',
            '[' to ']'
        )
        
        val blackets = Stack<Char>()
        
        for (c in s) {
            val close = blacketMap[c]
            if (close != null) blackets.push(c)
            else if (blackets.isEmpty() 
                     || c != blacketMap[blackets.pop()]) {
                return false
            }
        }
        
        return blackets.isEmpty()
    }
}
