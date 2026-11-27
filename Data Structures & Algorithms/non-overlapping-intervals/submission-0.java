/*

[[1,2],[1,4],[2,4]]



1  2
1        4
   2     4




1  2
1                10
   2  3
      3  4


   x     y
z           k

*/

class Solution {

    boolean isOverlapping(int[] a, int[] b) {
        return b[1] > a[0] && b[0] < a[1];
    }

    int[] pickSmallest(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.min(a[1], b[1])};
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        var count = 0;
        var i = 0;
        while (i < intervals.length) {
            var j = i+1;
            while (j < intervals.length && isOverlapping(intervals[i], intervals[j])) {
                intervals[i] = pickSmallest(intervals[i], intervals[j++]);
                count++;
            }
            i = j;
        }
        return count;
    }
}
