class Solution {
    int toAdd = 0;

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.right);
        int temp = node.val;
        node.val += toAdd;
        toAdd += temp;
        traverse(node.left);
    }
}
