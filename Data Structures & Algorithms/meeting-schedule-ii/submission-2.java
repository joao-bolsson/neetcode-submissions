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

0                           40
   5   10
      
       10  20 

                     i
startTimes = [0, 5, 10]
endTimes   = [10,20,40]
                 j

             if (startTime[i] < endTime[j]) onGoing++; i++
             else onGoing--; j++

- sort intervals by start time

*/
class Solution {

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        var startTime = new int[intervals.size()];
        var endTime = new int[intervals.size()];

        for (var i = 0; i < intervals.size(); i++) {
            var m = intervals.get(i);
            startTime[i] = m.start;
            endTime[i] = m.end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        var onGoing = 0;
        var rooms = 0;
        int i = 0, j = 0;
        while (i < startTime.length) {
            if (startTime[i] < endTime[j]) {
                onGoing++; 
                i++;
            } else {
                rooms = Math.max(rooms, onGoing);
                onGoing--; 
                j++;
            }
        }
        return Math.max(rooms, onGoing);
    }
}
