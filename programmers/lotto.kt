class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val winNums = win_nums.toHashSet()
        
        var match = 0
        var miss = 0
        
        lottos.forEach { 
            if (it in winNums) match += 1
            if (it == 0) miss += 1
        }
        
        fun rank(n: Int) = when (n) {
            in 2..6 -> 7 - n
            else -> 6
        }
        
        return intArrayOf(rank(match + miss), rank(match))
    }
}

//Array.toHashSet(), Iterable.toHashSet()
