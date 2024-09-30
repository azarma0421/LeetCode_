class Solution {
    public int[] productExceptSelf(int[] nums) {
        int current = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            ans[i] = current;
            current *= nums[i];
        }
        current = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= current;
            current *= nums[i];
        }
        return ans;
    }
}