
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();

        while (true) {
            if (++count == k)
                return root.val;
            if (root.right != null) {
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
            root = stack.pop();
        }
    }
}