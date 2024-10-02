class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int ans = nums[0];
        int n = nums.length - 1;

        for (int i = 0; i <= n; i++) {
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;
            left *= nums[i];
            right *= nums[n - i];
            ans = Math.max(Math.max(left, right), ans);
        }
        return ans;
    }
}