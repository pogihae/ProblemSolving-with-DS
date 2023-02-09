//java arr -> list
//java sub list
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> mNums = new ArrayList<>(nums.length);
        for (int n : nums) {
            mNums.add(n);
        }
        return buildTree(mNums);
    }

    private TreeNode buildTree(List<Integer> nums) {
        if (nums.isEmpty()) return null;

        int midIdx = nums.size() / 2;
        TreeNode pivot = new TreeNode(nums.get(midIdx));

        List<Integer> lefts = nums.subList(0, midIdx);
        List<Integer> rights = nums.subList(midIdx + 1, nums.size());

        pivot.left = buildTree(lefts);
        pivot.right = buildTree(rights);

        return pivot;
    }
}
