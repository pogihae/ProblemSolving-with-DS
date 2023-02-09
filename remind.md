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

### Array To List

```array2List.java
  //not primitive array
  List<T> list = Arrays.asList(arr);
  //primitive array
  List<Integer> list = new List<>();
  for () {} // add all
```

### Sub List

```subList.java
  //참조 공유되는 서브 리스트를 반환한다.
  //아이템 참조 공유 외에도 리스트 그 자체의 참조를 공유한다.
  List.subList(from, to) // exclusive end
```
