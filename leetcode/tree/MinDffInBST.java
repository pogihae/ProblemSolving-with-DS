//Math.abs return type?
class Solution {
    int minDiff = Integer.MAX_VALUE;
    int toCompare = -1;

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return minDiff;
    }

    void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);
        if (toCompare != -1) {
            int diff = Math.abs(node.val - toCompare);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        toCompare = node.val;
        traverse(node.right);
    }
}
