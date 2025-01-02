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
        if (root == null)
            return null;
        TreeNode newNode = new TreeNode(root.val);
        copy(root, newNode);
        return newNode;
    }

    private void copy(TreeNode root, TreeNode newNode) {

        if (root.left != null) {
            newNode.right = new TreeNode(root.left.val);
            copy(root.left, newNode.right);
        }
        if (root.right != null) {
            newNode.left = new TreeNode(root.right.val);
            copy(root.right, newNode.left);
        }
    }
}