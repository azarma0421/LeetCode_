class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if (nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else if (nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }
}