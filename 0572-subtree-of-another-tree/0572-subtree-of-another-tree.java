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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (sameRoot(root, subRoot))
            return true;
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean sameRoot(TreeNode root, TreeNode subRoot) {
        if (root == subRoot && root == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        if (root.val == subRoot.val) {
            return (sameRoot(root.left, subRoot.left) && sameRoot(root.right, subRoot.right));
        }
        return false;
    }
}