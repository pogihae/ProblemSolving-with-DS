class Solution {
    fun maxDepth(root: TreeNode?): Int {
        fun traverse(node: TreeNode?, depth: Int): Int {
            if (node == null) return depth
            
            val rightDepth = node.right?.let { traverse(it, depth + 1) } ?: depth
            val leftDepth = node.left?.let { traverse(it, depth + 1) } ?: depth
            
            return maxOf(rightDepth, leftDepth)
        }
        
        return root?.let { traverse(it, 1) } ?: 0
    }
}

class Solution2 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        
        return 1 + maxOf(leftDepth, rightDepth)
    }
}


class Solution3 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        
        val deq = ArrayDeque<TreeNode>()
        var depth = 0
        
        deq.addLast(root)
        
        while (deq.isNotEmpty()) {
            depth += 1
            repeat(deq.size) {
                val next = deq.removeFirst()
                next.left?.let { deq.addLast(it) }
                next.right?.let { deq.addLast(it) }
            }
        }
        
        return depth
    }
}
