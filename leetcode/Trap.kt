class Solution {
    fun trap(height: IntArray): Int {
        var answer = 0
       
        var left = 0
        var right = height.lastIndex
        
        var leftMax = height[left]
        var rightMax = height[right]
        
        while (left < right) {
            leftMax = maxOf(height[left], leftMax)
            rightMax = maxOf(height[right], rightMax)
            
            if (leftMax > rightMax) {
                answer += rightMax - height[right]
                right -= 1
            }
            else {
                answer += leftMax - height[left]
                left += 1
            }
        }
        
        return answer
    }
}
