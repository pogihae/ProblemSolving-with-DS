class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        
        val selected = ArrayDeque<Int>(candidates.size)
        
        fun dfs(start: Int, sum: Int) {
            if (sum > target) return
            if (sum == target) {
                answer.add(selected.toMutableList())
                return
            }
            
            for (idx in start until candidates.size) {
                //select it
                selected.addLast(candidates[idx])
                dfs(idx, sum + candidates[idx])
                //unselect it
                selected.removeLast()
            }
        }
        
        dfs(0, 0)
        
        return answer
    }
}
