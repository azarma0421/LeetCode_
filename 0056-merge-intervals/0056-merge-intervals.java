import java.util.Comparator;
class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->(Integer.compare(a[0],b[0])));
        List<int[]> res = new ArrayList<>();
		int[] newinterval = intervals[0];
        for(int[] d:intervals){

            if (d[0]<=newinterval[1]){
				newinterval[1] = Math.max(newinterval[1],d[1]);
			} else{
				res.add(newinterval);
				newinterval = d;
			}
        }
		res.add(newinterval);
        return res.toArray(new int[res.size()][]);
    }
}