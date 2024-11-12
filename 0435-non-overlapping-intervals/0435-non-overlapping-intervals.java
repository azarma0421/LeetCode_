class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int pre = 0;
        int join = 1;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {
                join++;
                pre = i;
            }
        }

        return intervals.length - join;
    }
}