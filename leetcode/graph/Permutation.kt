class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answers = mutableListOf<List<Int>>()
        
        fun dfs(selected: Int, list: List<Int>) {
            if (list.size == nums.size) {
                answers.add(list)
                return
            }
            
            for ((i,n) in nums.withIndex()) {
                if ((selected and (1 shl i)) == 0) {
                    val newList = mutableListOf<Int>().apply {
                        addAll(list)
                        add(n)
                    }
                    dfs(selected or (1 shl i), newList)
                }
            }
        }
        
        dfs(0, listOf<Int>())
        
        return answers
    }
}

//kotlin List contain add ??
//No!, MutableList<> contains add only

//kotlin count one bit -> Integer.bitCount(num)

class Solution2 {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        
        val res = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        
        fun dfs() {
            if (res.size == nums.size) {
                answer.add(res.toMutableList())
                return
            }
            
            for (num in nums) {
                if (num !in visited) {
                    visited.add(num)
                    res.addLast(num)
                    dfs()
                    visited.remove(num)
                    res.removeLast()
                }
            }
        }
        
        dfs()
        
        return answer
    }
}
