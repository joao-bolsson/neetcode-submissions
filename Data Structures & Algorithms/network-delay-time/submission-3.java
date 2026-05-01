class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var distance = new int[n];
        Arrays.fill(distance, -1);

        // node -> [other node, time]
        var map = new HashMap<Integer, List<int[]>>();
        for (var time : times) map.computeIfAbsent(time[0] - 1, p -> new ArrayList<int[]>()).add(new int[]{time[1] - 1, time[2]});

        var queue = new PriorityQueue<int[]>(Comparator.comparing(arr -> arr[1])); // min heap
        queue.add(new int[]{k-1, 0});

        while (!queue.isEmpty()) {
            var curr = queue.poll();

            var node = curr[0];
            if (distance[node] > -1) continue; // node already visited
            distance[node] = curr[1];

            for (var next : map.getOrDefault(node, List.of())) {
                if (distance[next[0]] > -1) continue;
                queue.add(new int[]{next[0], curr[1] + next[1]});
            }
        }

        var min = Integer.MIN_VALUE;
        for (var time : distance) {
            if (time == -1) return -1; // not possible to reach all nodes
            min = Math.max(min, time);
        }
        return min;
    }
}