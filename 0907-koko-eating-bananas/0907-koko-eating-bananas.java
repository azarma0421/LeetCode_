class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(piles, h, mid))
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private boolean check(int[] piles, int h, int mid) {
        int curTime = 0;
        for (int p : piles) {
            curTime += p / mid;
            curTime += p % mid != 0 ? 1 : 0;
        }
        return curTime > h;
    }
}