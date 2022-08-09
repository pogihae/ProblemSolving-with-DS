class Solution {
    fun longestUnivaluePath(root: TreeNode?): Int {
        var answer = 0
        
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0
            
            var left = dfs(node.left)
            var right = dfs(node.right)
            
            if (node.left?.`val` != node.`val`) left = 0
            if (node.right?.`val` != node.`val`) right = 0
            
            answer = maxOf(answer, left + right)
            
            return 1 + maxOf(left, right)
        }
        
        dfs(root)
        
        return answer
    }
}
