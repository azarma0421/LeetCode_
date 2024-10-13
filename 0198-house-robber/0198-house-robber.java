class Solution {
    public int rob(int[] nums) {
        int[] sum = new int[nums.length];
        if (nums.length == 1)
            return nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i - 2 < 0)
                sum[i] = nums[i];
            else if (i == 2)
                sum[i] = nums[0] + nums[i];
            else
                sum[i] = nums[i] + Math.max(sum[i - 2], sum[i - 3]);
        }

        return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
    }
}