/*

  .     . 
.             .

*/
class Solution {

    boolean isOverlapping(int[] a, int[] b) {
        return b[1] >= a[0] && b[0] <= a[1];
    }

    int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public int[][] merge(int[][] intervals) {
        // sort intervals by start_time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // n logn

        var res = new ArrayList<int[]>();
        int i = 0;
        while (i < intervals.length) { // n
            var j = i;
            while (j < intervals.length && isOverlapping(intervals[i], intervals[j])) {
                intervals[i] = merge(intervals[i], intervals[j++]);
            }
            res.add(intervals[i]);
            i = j;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
