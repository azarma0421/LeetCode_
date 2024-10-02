class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (sum < 0)
                sum = num;
            else
                sum = sum + num;
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}