class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> mPre = new ArrayList<>(preorder.length);
        List<Integer> mIn = new ArrayList<>(inorder.length);

        for (int i=0; i<preorder.length; i++) {
            mPre.add(preorder[i]);
            mIn.add(inorder[i]);
        }

        return buildTreeUtil(mPre, mIn);
    }

    TreeNode buildTreeUtil(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty()) return null;

        int rootVal = preorder.get(0);
        int rootIdx = -1;
        for (int i=0; i<inorder.size(); i++) {
            if (inorder.get(i) == rootVal) {
                rootIdx = i;
                break;
            }
        }

        List<Integer> leftPre = preorder.subList(1, rootIdx + 1);
        List<Integer> leftIn = inorder.subList(0, rootIdx);

        List<Integer> rightPre = preorder.subList(rootIdx+1, preorder.size());
        List<Integer> rightIn = inorder.subList(rootIdx+1, inorder.size());

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeUtil(leftPre, leftIn);
        root.right = buildTreeUtil(rightPre, rightIn);

        return root;
    }
}
