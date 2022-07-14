class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val visit = HashMap<Char, Boolean>()
        val deque = ArrayDeque<Char>()
        
        var maxLen = 0
        
        for (char in s) {
            if (visit[char] != true) {
                visit[char] = true
            } else {
                while (deque.firstOrNull() != char) {
                    visit[deque.removeFirst()] = false
                }
                deque.removeFirst()
            }
            
            deque.addLast(char)
            maxLen = maxOf(deque.size, maxLen)
        }
        
        return maxLen
    }
}

//kotlin ? type separated, so *orNull fun or throw exception

//kotlin deque
