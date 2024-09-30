class Solution {
    public int search(int[] nums, int target) {
        return getNum(nums, 0, nums.length - 1, target);
    }

    // [-1,0,3,5,9,12]
    private int getNum(int[] nums, int min, int max, int target) {
        int mid = (max + min) / 2;
        if (nums[mid] == target)
            return mid;
        else if (min + 1 == max && nums[mid + 1] == target) {
            return mid + 1;
        } else if (min + 1 == max || min == max) {
            return -1;
        }

        if (target > nums[mid])
            return getNum(nums, mid, max, target);
        else
            return getNum(nums, min, mid, target);

    }
}