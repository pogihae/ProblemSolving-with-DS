class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        
        prices.reduceIndexed { i, min, value -> 
            max = maxOf(max, value - min)
            minOf(min, value)
        }
        
        return max
    }
}
