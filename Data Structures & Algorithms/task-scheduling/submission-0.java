class Solution {

    record Task(int availableTime, int freq) implements Comparable<Task> {
        
        public int compareTo(Task other) {
            return availableTime - other.availableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        var map = new int[26];
        Arrays.fill(map, 0);
        for (var c : tasks) map[c - 'A']++;

        var pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
        for (var i = 0; i < map.length; i++) if (map[i] > 0) pq.add(map[i]);

        var coolDown = new PriorityQueue<Task>(); // min heap

        var currTime = 0;

        while (!pq.isEmpty() || !coolDown.isEmpty()) {
            while (!coolDown.isEmpty() && coolDown.peek().availableTime <= currTime) pq.add(coolDown.poll().freq);
            currTime++;

            if (pq.isEmpty()) continue; // idle
            
            var curr = pq.poll();
            if (curr > 1) coolDown.add(new Task(currTime + n, curr - 1));
        }

        return currTime;
    }
}