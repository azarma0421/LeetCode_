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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        int level = 0;
        List<List<Integer>> levelList = new ArrayList<>();
        levelList.add(new ArrayList<>());

        return genLevelList(level, root, levelList);
    }

    private List<List<Integer>> genLevelList(int lv, TreeNode node, List<List<Integer>> levelList) {
        if (node == null)
            return levelList;

        if (lv >= levelList.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            levelList.add(list);
        } else {
            levelList.get(lv).add(node.val);
        }

        levelList = genLevelList(lv + 1, node.left, levelList);
        levelList = genLevelList(lv + 1, node.right, levelList);

        return levelList;
    }
}