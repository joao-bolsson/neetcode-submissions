/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

/*

0           30
   5  10

5   8
      9   15
*/

class Solution {

    boolean conflict(Interval prev, Interval curr) {
        return curr.start >= prev.start && curr.start < prev.end;
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for (var i = 1; i < intervals.size(); i++) {
            var prev = intervals.get(i-1);
            var curr = intervals.get(i);

            if (conflict(prev, curr)) return false;
        }
        return true;
    }
}
