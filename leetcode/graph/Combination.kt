class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        val res = ArrayDeque<Int>()
        
        fun dfs(idx: Int) {
            if (res.size == k) {
                answer.add(res.toMutableList())
                return
            }
            
            for (i in idx..n) {
                res.addLast(i)
                dfs(i+1)
                res.removeLast()
            }
        }
        
        dfs(1)
        
        return answer
    }
}
