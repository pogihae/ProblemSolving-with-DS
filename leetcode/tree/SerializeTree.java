public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                
                result.add(String.valueOf(node.val));
            } else {
                result.add("#");
            }
        }

        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] nodeValues = data.split(",");
        TreeNode root = strToNode(nodeValues[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = strToNode(nodeValues[idx++]);
            if (left != null) {
                queue.add(left);
            }

            TreeNode right = strToNode(nodeValues[idx++]);
            if (right != null) {
                queue.add(right);
            }

            node.left = left;
            node.right = right;
        }

        return root;
    }

    private TreeNode strToNode(String value) {
        if (value.equals("#")) return null;
        return new TreeNode(Integer.parseInt(value));
    }
}
