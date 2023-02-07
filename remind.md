### BFS
```bfs.java
  void bfs(Node root) {
    Map<Node, Boolean> visit = new HashMap<>();
    Queue<Node> que = new LinkedList<>();
    
    visit.put(root, true);
    que.add(root);
    
    while (!que.isEmpty()) {
      Node node = que.poll();
      
      for (Node child : node.childs) {
        if (visit.get(child) == false) {
          visit.put(child, true);
          que.add(child);
        }
      }
    }
  }
```
    
    
### Binary Tree Traversal

```traversal.java
  void traversal(Node root) {
    if (root == null) return;
    //pre-order
    traversal(root.left);
    //in-order
    traversal(root.right);
    //post-order
  }
```
