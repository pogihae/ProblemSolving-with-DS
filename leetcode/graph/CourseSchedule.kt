class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = hashMapOf<Int, MutableList<Int>>()
        
        for (pre in prerequisites) {
            graph.getOrPut(pre[1], ::ArrayList).add(pre[0])
        }
        
        val traced = BooleanArray(numCourses)
        val visited = BooleanArray(numCourses)
        fun hasCycle(start: Int): Boolean {
            if (traced[start]) return true
            
            if (visited[start]) return false
            visited[start] = true
            
            val ends = graph[start] ?: return false
            
            traced[start] = true
            for (end in ends) {
                if (hasCycle(end)) {
                    traced[start] = false
                    return true
                }
            }
            
            traced[start] = false
            
            return false
        }
        
        for (start in graph.keys) {
            if (hasCycle(start)) return false
        }
        
        return true
    }
}
