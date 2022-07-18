fun dfs(row: Int, col: Int) {
  if (row !in 0 until maxRow
      || col !in 0 until maxCol
      || grid[row][col] == visited) {
      
      return
  }
  
  for (n in grid[row][col].adjacents()) {
    if (n != visited) {
      dfs(n.row, n.col)
    }
  }
}

fun dfs(node: Node) {
  val stack = ArrayDeque<Node>().apply {
    push(node)
  }
  
  while (stack.isNotEmpty()) {
    val n = stack.pop().apply {
      visited = true
    }
    
    n.adjacents()
      .asSequence()
      .filter { it.visited == false }
      .forEach { stack.push(it) }
  }
}
