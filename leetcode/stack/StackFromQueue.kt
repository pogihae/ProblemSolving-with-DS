class MyStack() {

    val q1: Queue<Int> = LinkedList<Int>()
    val q2: Queue<Int> = LinkedList<Int>()
    
    fun push(x: Int) {
        val (curQ, anotherQ) = curQAndAnotherQ()
        curQ.add(x)
    }

    fun pop(): Int {
        val (curQ, anotherQ) = curQAndAnotherQ()
        
        while (curQ.size > 1) {
            anotherQ.add(curQ.poll())
        }
        
        return curQ.poll()
    }

    fun top(): Int {
        val (curQ, anotherQ) = curQAndAnotherQ()
        
        while (curQ.size > 1) {
            anotherQ.add(curQ.poll())
        }
        
        val res = curQ.poll()
        anotherQ.add(res)
        
        return res
    }

    fun empty() = q1.isEmpty() && q2.isEmpty()
    
    fun curQAndAnotherQ() = 
        if (q1.isEmpty()) q2 to q1 else q1 to q2
}

// queue.add vs .offer
// if isFull : add -> Exception, offer -> false

// queue.remove vs .poll
// if is Empty : remove -> Exception, poll -> null

// queue.element vs .peek
// Exception, null
