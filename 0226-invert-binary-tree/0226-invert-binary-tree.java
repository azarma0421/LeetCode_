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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        return copyTree(root, newRoot);

    }

    private TreeNode copyTree(TreeNode root, TreeNode newRoot) {
        if (root == null)
            return newRoot;

        if (root.left != null) {
            newRoot.right = new TreeNode(root.left.val);
            copyTree(root.left, newRoot.right);
        }

        if (root.right != null) {
            newRoot.left = new TreeNode(root.right.val);
            copyTree(root.right, newRoot.left);
        }

        return newRoot;
    }

}