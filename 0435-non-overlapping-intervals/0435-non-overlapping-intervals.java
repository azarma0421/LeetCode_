class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1)
            return 0;

        int pre = 0;
        int join = 1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {
                pre = i;
                join++;
            }
        }
        return intervals.length - join;
    }
}