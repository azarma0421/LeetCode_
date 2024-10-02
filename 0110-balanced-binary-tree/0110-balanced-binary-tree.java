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
    public boolean isBalanced(TreeNode root) {
        return !(getDepth(root,0) == -1);
    }

    private int getDepth(TreeNode root, int depth) {
        if (root == null)
            return depth;

        int leftDep = getDepth(root.left, depth + 1);
        int rightDep = getDepth(root.right, depth + 1);

        if (leftDep == -1 || rightDep == -1)
            return -1;

        if (Math.abs(leftDep - rightDep) <= 1)
            return Math.max(leftDep, rightDep);
        return -1;
    }

}