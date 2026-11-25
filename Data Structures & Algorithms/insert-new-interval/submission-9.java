class Solution {

    int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        var res = new ArrayList<int[]>();

        for (var i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                // add before the current interval
                res.add(newInterval);
                while (i < intervals.length) res.add(intervals[i++]);
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                // overlapping
                newInterval = merge(newInterval, intervals[i]);
            }
            if (i == intervals.length - 1) res.add(newInterval);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
