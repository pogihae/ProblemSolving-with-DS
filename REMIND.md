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

### SQL
```sql
DATE_FORMAT(date, '%Y%m')
```

### Priority Queue
```que.java
  Queue<T> pq = new PriorityQueue<>(Collections.reverseOrder());
  Queue<T> pq = new PriorityQueue<>(length, Collections.reverseOrder());
```

### Merge Sort
```merge.java
  void mergeSort(int[] arr, int lo, int hi) {
    if (lo == hi) return;
    
    int mid = (lo + hi) / 2;
    mergeSort(arr, lo, mid);
    mergeSort(arr, mid+1, hi);
    
    merge(arr, lo, mid, hi);
  }
  
  void merge(int[] arr, int lo, int mid, int hi) {
    int[] temp = new int[hi - lo + 1];
    int tempIdx = 0;
    
    int left = lo;
    int right = mid + 1;
    
    while (left <= mid && right <= hi) {
      if (arr[left] < arr[right]) {
        temp[tempIdx] = arr[left];
      } else {
        temp[tempIdx] = arr[right];
      }
      tempIdx += 1;
    }
    
    while (left <= mid) {
      temp[tempIdx++] = arr[left++];
    }
    
    while (right <= hi) {
      temp[tempIdx++] = arr[right++];
    }
    
    for (int i=0; i<tempIdx; i++) {
      arr[lo++] = temp[i];
    }
  }

```
