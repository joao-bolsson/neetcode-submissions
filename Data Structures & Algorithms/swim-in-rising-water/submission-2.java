class Solution {

    // [offsetI, offsetJ]
    int[][] moves = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    void buildConnections(int i, int j, int n, int[][] grid, Map<Integer, List<int[]>> map) {
        var curr = i * n + j;
        for (var move : moves) {
            var nI = i + move[0];
            var nJ = j + move[1];

            if (nI < 0 || nJ < 0 || nI >= n || nJ >= n) continue;

            var nextNode = nI * n + nJ;
            var nextVal = grid[nI][nJ];

            map.computeIfAbsent(curr, k -> new ArrayList<int[]>()).add(new int[]{nextNode, nextVal});
        }
    }

    public int swimInWater(int[][] grid) {
        var n = grid.length;

        // node -> [node, elevation]
        var map = new HashMap<Integer, List<int[]>>();
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                buildConnections(i, j, n, grid, map);
            }
        }

        var to = n * n - 1;

        var queue = new PriorityQueue<int[]>(Comparator.comparing(arr -> arr[1]));
        queue.add(new int[]{0, grid[0][0]});

        var visited = new int[n*n];
        Arrays.fill(visited, -1);

        while (!queue.isEmpty()) {
            var curr = queue.poll();

            var node = curr[0];

            if (visited[node] > -1) continue;
            visited[node] = curr[1];

            if (node == to) break;

            for (var next : map.getOrDefault(node, List.of())) {
                if (visited[next[0]] > -1) continue;

                // The time needed to reach 'next' is the maximum of current time and the next cell's elevation
                queue.add(new int[]{next[0], Math.max(curr[1], next[1])});
            }
        }

        return visited[to];
    }
}