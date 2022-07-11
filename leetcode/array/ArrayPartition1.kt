class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        return nums.asSequence()
                .sorted()
                .foldIndexed(0) {idx, sum, value -> 
                    if (idx % 2 == 0) sum + value
                    else sum
                }
    }
}

//greedy
