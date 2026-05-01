class Solution {

    int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        // point -> [other, dist]
        var map = new HashMap<Integer, List<int[]>>();
        for (var i = 0; i < points.length-1; i++) {
            for (var j = i+1; j < points.length; j++) {
                var dist = distance(points[i], points[j]);
                map.computeIfAbsent(i, k -> new ArrayList<int[]>()).add(new int[]{j, dist});
                map.computeIfAbsent(j, k -> new ArrayList<int[]>()).add(new int[]{i, dist});
            }
        }

        // [src, to, weigth]
        var queue = new PriorityQueue<int[]>(Comparator.comparing(arr -> arr[2])); // min heap
        var first = 0;
        for (var other : map.getOrDefault(first, List.of())) queue.add(new int[]{first, other[0], other[1]});

        var visited = new boolean[points.length];
        visited[first] = true;

        var minCost = 0;

        while (!queue.isEmpty()) {
            var curr = queue.poll();

            var from = curr[0];
            var to = curr[1];
            var dist = curr[2];

            if (visited[to]) continue;
            visited[to] = true;

            minCost += dist;

            for (var next : map.get(to)) {
                if (visited[next[0]]) continue;
                queue.add(new int[]{to, next[0], next[1]});
            }
        }
        return minCost;
    }
}