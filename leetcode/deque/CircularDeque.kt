class MyCircularDeque(val k: Int) {

    val head = Node(-1)
    val tail = Node(-1)
    
    var size = 0
    
    init {
        head.next = tail
        tail.prev = head
    }
    
    fun insertFront(value: Int): Boolean {
        if (isFull()) return false
        
        val node = Node(value)
        node.next = head.next
        node.prev = head
        
        head.next!!.prev = node
        head.next = node
        
        size += 1
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false
        
        val node = Node(value)
        node.prev = tail.prev
        node.next = tail
        
        tail.prev!!.next = node
        tail.prev = node
        
        size += 1
        
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false
        
        val rm = head.next
        
        rm!!.next!!.prev = head
        head.next = rm!!.next
        
        size -= 1
        
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false
        
        val rm = tail.prev
        
        rm!!.prev!!.next = tail
        tail.prev = rm!!.prev
        
        size -= 1
        
        return true
    }

    fun getFront() = if (isEmpty()) -1 else head.next!!.data

    fun getRear() = if (isEmpty()) -1 else tail.prev!!.data

    fun isEmpty() = size == 0

    fun isFull() = size == k
    
    class Node(val data: Int,
               var prev: Node? = null, 
               var next: Node? = null)
}

// default parameter always end of args
