class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) return listOf<String>()
        
        val digitToCharList = mapOf(
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z')
        )
        
        val answers = mutableListOf<String>()
        
        fun dfs(sb: String) {
            if (sb.length == digits.length) {
                answers.add(sb)
                return
            }
            
            for (d in digitToCharList[digits[sb.length]]!!) {
                dfs("${sb}${d}")
            }
        }
        
        dfs("")
        
        return answers
    }
}

//isEmpty -> check length
//isBlank -> check length and all of char is white space

class Solution2 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) return listOf<String>()
        
        val digitToChars = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )
        
        val answer = mutableListOf<String>()
        val res = ArrayDeque<Char>()
        
        fun dfs() {
            if (res.size == digits.length) {
                answer.add(res.joinToString("")) //iteration??
                return
            }
            
            for (ch in digitToChars[digits[res.size]]!!) {
                res.addLast(ch)
                dfs()
                res.removeLast()
            }
        }
        
        dfs()
        
        return answer
    }
}
