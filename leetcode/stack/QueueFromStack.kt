class MyQueue() {
    
    val s1 = Stack<Int>()
    val s2 = Stack<Int>()
    
    var isCurQ = false

    fun push(x: Int) {
        val (curS, anotherS) = curSAndAnotherS()
        
        if (isCurQ) {
            while (curS.isNotEmpty()) {
                anotherS.push(curS.pop())
            }
            anotherS.push(x)
            isCurQ = false
            return
        }
        
        curS.push(x)
    }

    fun pop(): Int {
        val (curS, anotherS) = curSAndAnotherS()
        
        if (isCurQ) return curS.pop()
        
        isCurQ = true
        
        while (curS.size > 1) {
            anotherS.push(curS.pop())
        }
        
        return curS.pop()
    }

    fun peek(): Int {
        val (curS, anotherS) = curSAndAnotherS()
        
        if (isCurQ) return curS.peek()
        
        isCurQ = true
        
        while (curS.size > 1) {
            anotherS.push(curS.pop())
        }
        
        val res = curS.pop()
        anotherS.push(res)
        
        return res
    }

    fun empty() = s1.isEmpty() && s2.isEmpty()
    
    fun curSAndAnotherS(): Pair<Stack<Int>, Stack<Int>> {
        val curS = if (s1.isEmpty()) s2 else s1
        val anotherS = if (s1 === curS) s2 else s1
        
        return curS to anotherS
    }
}

// cur is q? -> output is not empty?

class MyQueue2() {
    
    val input = Stack<Int>()
    val output = Stack<Int>()

    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        peek()
        return output.pop()
    }

    fun peek(): Int {
        if (output.isNotEmpty()) return output.peek()
        
        while (input.isNotEmpty()) {
            output.push(input.pop())
        }
        
        return output.peek()
    }

    fun empty() = input.isEmpty() && output.isEmpty()
}
