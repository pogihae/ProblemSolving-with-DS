class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        
        nums.foldIndexed(1) { i, mul, value ->
            answer[i] = mul
            mul * value
        }
        
        nums.foldRightIndexed(1) { i, value, mul ->
            answer[i] *= mul
            mul * value
        }
        
        return answer
    }
}
