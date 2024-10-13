class Solution {
    public int rob(int[] nums) {
        int max = 0;
        int[] sum = new int[nums.length];

        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if (nums.length == 3)
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        for (int i = 0; i < nums.length - 1; i++) {
            sum[i] = nums[i];
            if (i == 2)
                sum[i] += nums[0];
            if (i > 2) {
                sum[i] += Math.max(sum[i - 2], sum[i - 3]);
            }
        }
        max = Math.max(sum[nums.length - 2], sum[nums.length - 3]);
        for (int i = 1; i <= nums.length - 1; i++) {
            sum[i] = nums[i];
            if (i == 3)
                sum[i] += nums[1];
            if (i > 3) {
                sum[i] += Math.max(sum[i - 2], sum[i - 3]);
            }
        }

        max = Math.max(max, sum[nums.length - 1]);
        max = Math.max(max, sum[nums.length - 2]);
        return max;
    }
}