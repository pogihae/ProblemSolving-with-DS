class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        
        prices.reduce { min, value -> 
            max = maxOf(max, value - min)
            minOf(min, value)
        }
        
        return max
    }
}
