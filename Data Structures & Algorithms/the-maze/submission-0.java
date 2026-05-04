class Solution {

    int[][] moves = new int[][] {
        {0,1},
        {0,-1},
        {-1,0},
        {1,0}
    };
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze[start[0]][start[1]] == 1) return false; // starts on a wall

        var queue = new LinkedList<int[]>();
        queue.add(start);

        var visited = new boolean[maze.length][maze[0].length];

        while (!queue.isEmpty()) {
            var curr = queue.pop();
            int i = curr[0], j = curr[1];
            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (var m : moves) {
                i = curr[0];
                j = curr[1];
                while (i >= 0 && i < maze.length && j >= 0 && j < maze[i].length && maze[i][j] == 0) {
                    i += m[0];
                    j += m[1];
                }
                //(i,j) is a wall
                i -= m[0];
                j -= m[1];

                if (i == destination[0] && j == destination[1]) return true; // the ball needs to stop rolling in the dest
                if (visited[i][j]) continue;
                queue.add(new int[]{i, j});
            }
        }
        return false;
    }
}
