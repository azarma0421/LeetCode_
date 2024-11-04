class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        Arrays.sort(nums);

        int count = 1;
        int max_count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                max_count = Math.max(count, max_count);
                count = 1;
            }
        }
        return Math.max(count, max_count);
    }
}