//array sort
//list to array

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] == i2[0]) return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        
        List<int[]> newIntervals = new LinkedList<>();

        int pivotIdx = 0;

        for (int i=1; i<intervals.length; i++) {
            if (intervals[pivotIdx][1] >= intervals[i][0]) {
                intervals[pivotIdx][1] = Math.max(intervals[i][1], intervals[pivotIdx][1]);
            } else {
                newIntervals.add(intervals[pivotIdx]);
                pivotIdx = i;
            }
        }

        newIntervals.add(intervals[pivotIdx]);

        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }
}
