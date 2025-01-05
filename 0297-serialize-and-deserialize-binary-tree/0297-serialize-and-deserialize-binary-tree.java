/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                res += "n,";
            else {
                queue.add(node.left);
                queue.add(node.right);
                res += String.valueOf(node.val) + ",";
            }
        }
        System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        if ("n".equals(str[0]))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        queue.add(root);
        for (int i = 1; i < str.length - 1; i++) {
            TreeNode node = queue.poll();
            if (!"n".equals(str[i])) {
                node.left = new TreeNode(Integer.valueOf(str[i]));
                queue.add(node.left);
            }
            if (!"n".equals(str[++i])) {
                node.right = new TreeNode(Integer.valueOf(str[i]));
                queue.add(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));