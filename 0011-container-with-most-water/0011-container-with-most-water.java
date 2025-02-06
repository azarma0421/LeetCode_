class Solution {
    public int maxArea(int[] height) {
        int S = 0;
        int E = height.length-1;
        int ans=0;
        int tem;

        while(E-S != 0){
            tem = (E-S) * Math.min(height[S],height[E]);
            ans = Math.max(ans,tem);
            if(height[S] > height[E]){
                E--;
            }else{
                S++;
            }
        }
        return ans;
    }
}