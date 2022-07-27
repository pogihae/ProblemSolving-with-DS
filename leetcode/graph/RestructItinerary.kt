class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val ends = hashMapOf<String, ArrayList<String>>()
        
        for (ticket in tickets) {
            ends.getOrPut(ticket[0], ::ArrayList).add(ticket[1])
        }
        
        for (targets in ends.values) {
            targets.sort()
        }
        
        val path = ArrayDeque<String>()
        
        fun dfs(start: String): Boolean {
            if (path.size == tickets.size) {
                return true
            }
            
            val targets = ends[start] ?: return false
            
            for (idx in 0 until targets.size) {
                val newStart = targets[idx] ?: throw IllegalStateException()
                
                targets.removeAt(idx)
                path.addLast(newStart)
                
                if (dfs(newStart)) return true
                
                targets.add(idx, newStart)
                path.removeLast()
            }
            
            return false
        }
        
        dfs("JFK")
        
        return path.run { 
            addFirst("JFK")
            toList()
        }
    }
}

class Solution2 {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val ends = hashMapOf<String, ArrayList<String>>()
        
        val mTickets = tickets.sortedBy { it[1] }
        
        for (ticket in mTickets) {
            ends.getOrPut(ticket[0], ::ArrayList).add(ticket[1])
        }
        
        val path = ArrayDeque<String>()
        
        fun dfs(start: String): Boolean {
            if (path.size == tickets.size) {
                return true
            }
            
            val targets = ends[start] ?: return false
            
            for (idx in 0 until targets.size) {
                val newStart = targets[idx] ?: throw IllegalStateException()
                
                targets.removeAt(idx)
                path.addLast(newStart)
                
                if (dfs(newStart)) return true
                
                targets.add(idx, newStart)
                path.removeLast()
            }
            
            return false
        }
        
        dfs("JFK")
        
        return path.run { 
            addFirst("JFK")
            toList()
        }
    }
}
