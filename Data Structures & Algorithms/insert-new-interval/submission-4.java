class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rs = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while(i<n && intervals[i][1] < newInterval[0]){
            rs.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }

        rs.add(newInterval);

        while(i<n){
            rs.add(intervals[i]);
            i++;
        }

        return rs.toArray(new int[rs.size()][]);
    }
}
