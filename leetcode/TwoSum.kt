class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIdx = HashMap<Int, Int>(nums.size / 2)
        
        for ((idx, value) in nums.withIndex()) {
            val targetIdx = numToIdx[target - value]
            
            if (targetIdx != null) return intArrayOf(idx, targetIdx)
            numToIdx[value] = idx
        }
        
        return intArrayOf(0, 0)
    }
}

// binary search condition lo <= hi
// index -> NO SORT

// withIndex()
// map[key]

class Solution2 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        
        val sorted = nums.sorted()
        
        var left = 0
        var right = nums.lastIndex;
        
        while (left < right) {
            val sum = sorted[left] + sorted[right]
            
            when {
                sum < target -> left += 1
                sum > target -> right -= 1
                else -> {
                    val (x, y) = getIndices(nums, sorted[left], sorted[right])
                    return intArrayOf(x, y)
                }
            }
        }
        
        return intArrayOf(-1, -1)
    }
    
    fun getIndices(nums: IntArray, a: Int, b: Int): Pair<Int, Int> {
        var x = -1
        var y = -1
        
        for ((i, v) in nums.withIndex()) {
            when  {
                (v == a && x == -1) -> x = i
                (v == b && y == -1) -> y = i
            }
        }
        
        return x to y
    }
}

//Pair, Triple


