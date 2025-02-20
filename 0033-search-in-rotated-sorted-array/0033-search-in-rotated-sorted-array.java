class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return findRotated(nums, target, left, right);
    }

    private int findRotated(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;

        if (nums[mid] == target)
            return mid;
        if (left >= right)
            return -1;

        if (nums[mid] > nums[right]) {
            if (nums[left] <= target && target < nums[mid]) {
                return findRotated(nums, target, left, mid - 1);
            } else {
                return findRotated(nums, target, mid + 1, right);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                return findRotated(nums, target, mid + 1, right);
            } else {
                return findRotated(nums, target, left, mid - 1);
            }
        }
    }
}