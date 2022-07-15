class MyHashMap() {
    
    val table = IntArray(1000001) { -1 }

    fun put(key: Int, value: Int) {
        table[key] = value
    }

    fun get(key: Int): Int {
        return table[key]
    }

    fun remove(key: Int) {
        table[key] = -1
    }
}

// kotlin func with -> lambda result
// kotlin also -> receiver object: it
