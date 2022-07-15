class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = Stack<Pair<Int, Int>>()
        val answer = IntArray(temperatures.size)
        
        for ((day, temperature) in temperatures.withIndex()) {
            while (stack.isNotEmpty() && stack.peek().second < temperature) {
                val rDay = stack.pop().first
                answer[rDay] = day - rDay
            }
            
            stack.push(day to temperature)
        }
        
        return answer
    }
}

//LinkedHashMap(mapOf) vs HashMap(hashMapOf): maintain input order
//pair -> using original array with saving index

class Solution2 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size)
        val days = Stack<Int>()
        
        for ((day, temp) in temperatures.withIndex()) {
            while (days.isNotEmpty() && temperatures[days.peek()] < temp) {
                val mDay = days.pop()
                answer[mDay] = day - mDay
            }
            
            days.push(day)
        }
        
        return answer
    }
}
