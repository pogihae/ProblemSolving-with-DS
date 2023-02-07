class Solution {
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return result;
    }

    int getHeight(TreeNode node) {
        if (node == null || result == false) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if (Math.abs(left - right) > 1) result = false;

        return Math.max(left, right) + 1;
    }
}
