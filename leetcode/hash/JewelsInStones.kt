class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val isJewel = BooleanArray(52)
        
        for (char in jewels) {
            val code = code(char)
            isJewel[code] = true
        }
        
        var answer = 0
        for (stone in stones) {
            val code = code(stone)
            answer += if (isJewel[code]) 1 else 0
        }
        
        return answer
    }
    
    fun code(c: Char) = if (c.isUpperCase()) {
                c - 'A' + 26
            } else {
                c - 'a'
            }
}

//kotlin Char
//toInt -> ASCII (deprecated) . digitToIntOrNull() -> real number
//toUpperCase(): Char -> upperCase(): String

//String.toInt() -> real integer

//expression v.s non-expression (cannot be used func() = ~~~)
