class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int ans = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(prices[i], max);
            ans = Math.max(ans, max - prices[i]);
        }
        return ans;
    }
}