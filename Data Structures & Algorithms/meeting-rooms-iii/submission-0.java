class Solution {

    record Room(int i, int availableAt) implements Comparable<Room> {
        public int compareTo(Room other) {
            if (availableAt == other.availableAt) return i - other.i;
            return availableAt - other.availableAt;
        }
    }

    record Meeting(int start, int end) implements Comparable<Meeting> {
        public int compareTo(Meeting other) {
            return start - other.start;
        }
    }
/*

0      10
  1    10
   2   10

n = 3

*/
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // sort by start
        
        var count = new int[n];

        var used = new PriorityQueue<Room>(); // min heap
        var free = new PriorityQueue<Room>(); // min heap
        for (var i = 0; i < n; i++) free.add(new Room(i, 0));

        for (var meeting : meetings) {
            var m = new Meeting(meeting[0], meeting[1]);

            // check if there is a used room that becomed available
            while (!used.isEmpty() && used.peek().availableAt <= m.start) {
                var room = used.poll();
                free.add(new Room(room.i, 0)); // available immediatelly
            }
            if (free.isEmpty()) {
                var room = used.poll();
                // 0,10
                // 5,20
                free.add(new Room(room.i, room.availableAt - m.start));
            }

            var room = free.poll();
            used.add(new Room(room.i, room.availableAt + m.end));

            count[room.i]++;
        }

        var max = Integer.MIN_VALUE;
        var ans = -1;
        for (var i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                ans = i;
            }
        }
        return ans;
    }
}