class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(intervals[i][1], temp[1]);
            } else {
                ans.add(temp);
                temp = intervals[i];
            }
        }
        ans.add(temp);

        return ans.toArray(new int[ans.size()][]);
    }
}