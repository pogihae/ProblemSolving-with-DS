class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = hashMapOf<Int, Int>()
        
        for (n in nums) {
            counts.merge(n, 1, Integer::sum)
        }
        
        val pq = PriorityQueue<Pair<Int, Int>>(nums.size, compareByDescending { it.second })
        
        for ((n, count) in counts) {
            pq.add(n to count)
        }
        
        val answer = mutableListOf<Int>()
        
        for (i in 0 until k) {
            answer.add(pq.poll().first)
        }
        
        return answer.toIntArray()
    }
}

//kotlin pair mutable??
// Pair(val first, val second)


//kotlin map for counter
//collections.groupingBy { it }.eachCount() -> Map<It, Int>
