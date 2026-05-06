class Solution {

    int[][] moves = new int[][] {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze[start[0]][start[1]] == 1) return -1; // starting on a wall

        var queue = new LinkedList<int[]>(); // cells to visit
        queue.add(new int[]{start[0], start[1], 0});

        var visited = new boolean[maze.length][maze[0].length];

        while (!queue.isEmpty()) {
            var curr = queue.pop();

            var i = curr[0];
            var j = curr[1];

            if (i == destination[0] && j == destination[1]) return curr[2]; // found

            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (var m : moves) {
                i = curr[0];
                j = curr[1];
                int dist = curr[2]; // 0
                while (i >= 0 && i < maze.length && j >= 0 && j < maze[i].length && maze[i][j] == 0) {
                    i += m[0];
                    j += m[1];
                    dist++;
                }
                // (i,j) -> is a wall of oob
                // back to previous valid position
                i -= m[0];
                j -= m[1];
                if (visited[i][j]) continue;
                dist--;
                queue.add(new int[]{i, j, dist});
            }
        }
        return -1;
    }
}
