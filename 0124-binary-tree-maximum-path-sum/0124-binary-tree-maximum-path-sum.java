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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        rootSum(root);
        return max;
    }

    public int rootSum(TreeNode root) {
        if (root == null)
            return 0;

        int LeftSum = Math.max(rootSum(root.left), 0);
        int RightSum = Math.max(rootSum(root.right), 0);

        max = Math.max(max, root.val + LeftSum + RightSum);

        return Math.max(root.val + LeftSum, root.val + RightSum);
    }
}