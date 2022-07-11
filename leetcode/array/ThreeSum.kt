class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        
        val answers = mutableListOf<List<Int>>()
        
        for (i in nums.indices) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i-1]) continue
            
            for (j in i+1..nums.lastIndex) {
                if (j > i+1 && nums[j] == nums[j-1]) continue
                
                val twoSum = nums[i] + nums[j]
                val targetIdx = binarySearch(nums, j+1, nums.lastIndex, twoSum * -1)
                
                if (targetIdx != -1) {
                    answers.add(
                        listOf(nums[i], nums[j], nums[targetIdx])
                    )
                }
            }
        }
        
        return answers
    }
    
    fun binarySearch(nums: IntArray, l: Int, h: Int, target: Int): Int {
        var low = l
        var hi = h
        
        while (low <= hi) {
            val mid = (low + hi) / 2
            
            when {
                nums[mid] > target -> hi = mid - 1
                nums[mid] == target -> return mid
                else -> low = mid + 1
            }
        }
        
        return -1
    }
}

//combination
//selected -> bit caution length
//서로 다른 n개의 원소!!

//중복 검사
//sorted and sequantial -> "same item skip"

class Solution2 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        
        nums.sort()
        
        for (i in 0..nums.lastIndex - 2) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue
            
            var left = i + 1
            var right = nums.lastIndex
            
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                
                when {
                    sum < 0 -> left += 1
                    sum > 0 -> right -= 1
                    else -> {
                        answer.add(listOf(nums[i], nums[left], nums[right]))
                        
                        left += 1
                        right -= 1
                    }
                }
                
                while (left > i+1 && left < right && nums[left] == nums[left-1]) left += 1
                while (right < nums.lastIndex && right > left && nums[right] == nums[right+1]) right -= 1
            }
        }
        
        return answer
    }
}
