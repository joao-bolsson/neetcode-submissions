/*

   x     y
z  k   

*/

class Solution {

    int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    boolean isOverlapping(int[] a, int[] b) {
        return (b[0] >= a[0] && b[0] <= a[1]) || (b[0] < a[0] && b[1] >= a[0]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var added = false;
        var res = new ArrayList<int[]>();

        for (var i = 0; i < intervals.length; i++) {
            if (isOverlapping(intervals[i], newInterval)) {
                intervals[i] = merge(intervals[i], newInterval);
                added = true;

                var j = i+1;
                while (j < intervals.length && isOverlapping(intervals[i], intervals[j])) {
                    intervals[i] = merge(intervals[i], intervals[j]);
                    j++;
                }
                res.add(intervals[i]);

                while (j < intervals.length) res.add(intervals[j++]);
                break;
            } else if (intervals[i][0] > newInterval[0]) {
                res.add(newInterval);
                res.add(intervals[i]);
                added = true;
                var j = i+1;
                while (j < intervals.length) res.add(intervals[j++]);
                break;
            }
            res.add(intervals[i]);
        }

        if (!added) res.add(newInterval);
        return res.toArray(new int[0][0]);
    }
}
