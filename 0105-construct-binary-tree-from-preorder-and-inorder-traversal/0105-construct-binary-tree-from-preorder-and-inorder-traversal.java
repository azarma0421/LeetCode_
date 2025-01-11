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

    int p = 0;
    int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null)
            return null;
        TreeNode root = genTree(preorder, inorder, Integer.MAX_VALUE);
        return root;
    }

    private TreeNode genTree(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length)
            return null;
        if (inorder[i] == stop) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[p++]);
        node.left = genTree(preorder, inorder, node.val);
        node.right = genTree(preorder, inorder, stop);
        return node;
    }
}