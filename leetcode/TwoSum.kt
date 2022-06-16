class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIdx = HashMap<Int, Int>(nums.size / 2)
        
        for ((idx, value) in nums.withIndex()) {
            val targetIdx = numToIdx.get(target - value)
            
            if (targetIdx != null) return intArrayOf(idx, targetIdx)
            numToIdx.put(value, idx)
        }
        
        return intArrayOf(0, 0)
    }
}


// binary search condition lo <= hi
// index -> sort x
// withIndex()
