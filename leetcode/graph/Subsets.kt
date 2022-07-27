// visit all nodes
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        
        val selected = ArrayDeque<Int>()
        
        fun dfs(start: Int) {
            answer.add(selected.toMutableList())
            
            for (idx in start until nums.size) {
                selected.addLast(nums[idx])
                dfs(idx+1)
                selected.removeLast()
            }
        }
        
        dfs(0)
        
        return answer
    }
}

// nCk
class Solution2 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        
        val selected = ArrayDeque<Int>() // stack
        
        fun comb(start: Int, k: Int) {
            if (selected.size == k) {
                answer.add(selected.toMutableList())
                return
            }
            
            for (idx in start until nums.size) {
                selected.addLast(nums[idx])
                comb(idx+1, k)
                selected.removeLast()
            }
        }
        
        for (k in 0..nums.size) {
            comb(0, k)
        }
        
        return answer
    }
}
