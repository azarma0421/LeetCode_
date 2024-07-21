class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        int pre_end = intervals[0][1];
        int res = 0;
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] < pre_end){
                res++;
            } else{
                pre_end = intervals[i][1];
            }
        }
        return res;
    }
}