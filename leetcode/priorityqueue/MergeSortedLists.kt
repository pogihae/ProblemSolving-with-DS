class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val root = ListNode(-1)
        val pq = PriorityQueue<ListNode>(lists.size + 1, compareByDescending { it.`val` }) 
       
        for (head in lists) {
            var tmp = head
            while (tmp != null) {
                pq.add(tmp)
                tmp = tmp.next
            }
        }
        
        while (pq.isNotEmpty()) {
            val node = pq.poll()
            node.next = root.next
            root.next = node
        }
        
        return root.next
    }
}

//kotlin Priority Queue

// import java.util.*

// val pq = PriorityQueue<Int>()
// val pq = PriorityQueue<Data> { data1, data2 -> data1.data.compareTo(data2.data) }
// val pq = PriorityQueue<Data>(size, compareBy { it.data })
// val pq = PriorityQueue<Data>(compareBy { it.data })

//Koltin Comparator

// val comp = object : Comparator<Data> {
//    override fun compare(o1: Int?, o2: Int?): Int {
//        
//    }
//}

// val comp = Comparator<Data> { x, y -> ~~~}
// val comp = compareBy<Data> { it.data }
// val comp = compareByDescending<Data> { it.data }
// val mulComp = compareBy<Data>(
//                  { it.data1 },  first sorted
//                  { it.data2 } ) after sorted addition sort
