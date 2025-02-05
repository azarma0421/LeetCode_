class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int k = (l + r) / 2;
        while (l <= r) {
            k = (l + r) / 2;
            int curTime = 0;
            for (int p : piles) {
                curTime += Math.ceil(1.0 * p / k);
            }
            if (curTime > h)
                l = k + 1;
            else
                r = k - 1;
        }
        return l;
    }
}