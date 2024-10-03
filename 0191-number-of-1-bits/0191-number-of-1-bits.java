class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        String num = Integer.toBinaryString(n);
        for (String s : num.split("")) {
            if ("1".equals(s))
                ans++;
        }
        return ans;
    }
}