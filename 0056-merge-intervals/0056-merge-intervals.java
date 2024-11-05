class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] < intervals[i][0]) {
                result.add(intervals[i - 1]);
            } else {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            }
        }
        result.add(intervals[intervals.length - 1]);
        return result.toArray(new int[result.size()][]);
    }
}