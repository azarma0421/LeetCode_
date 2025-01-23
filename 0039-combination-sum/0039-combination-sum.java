class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), 0, 0, target);
        return ans;
    }

    private void backtrack(int[] candidates, List<Integer> res, int start, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                return;
            res.add(candidates[i]);
            backtrack(candidates, res, i, sum + candidates[i], target);
            res.remove(res.size() - 1);
        }

    }
}