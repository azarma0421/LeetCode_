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
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        System.out.println("== ");
        if (root == null)
            return 0;
        int current = root.val;
        int leftsum = Math.max(dfs(root.left), 0);
        int rigthsum = Math.max(dfs(root.right), 0);
        max = Math.max(max, leftsum + current + rigthsum);
        return Math.max(current + leftsum, current + rigthsum);
    }
}