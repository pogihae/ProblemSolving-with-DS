class MyCircularQueue(val k: Int) {
    
    val arr = IntArray(k+1)
    
    var front = 0
    var rear = 1

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        
        arr[rear] = value
        rear = next(rear)
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        
        front = next(front)
        return true
    }

    fun Front() = if (isEmpty()) -1 else arr[next(front)]

    fun Rear() = if (isEmpty()) -1 else arr[prev(rear)]

    fun isEmpty() = next(front) == rear
    
    fun isFull() = front == rear
    
    fun next(p: Int) = (p + 1) % (k + 1)
    fun prev(p: Int) = if (p - 1 >= 0) p - 1 else k
}
