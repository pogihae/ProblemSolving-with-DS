class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var answer = 0
        
        fun maxDepth(node: TreeNode?): Int {
            if (node == null) return 0
            
            val left = maxDepth(node.left)
            val right = maxDepth(node.right)
            
            answer = maxOf(answer, left + right)
            
            return 1 + maxOf(left, right)
        }
        
        maxDepth(root)
        
        return answer
    }
}
