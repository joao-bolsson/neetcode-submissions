/*

0 1 0
1 1 1
0 1 0


add land and try to union with land surroundings
    - if ok: keep the same number os islands
        - if tried to connect with another land and its parent is different than mine: islands--
            my parent becomes parent of the other (union anyway)
    - if not: create another island
*/

class Solution {

    int[][] moves = new int[][] {
        {0, 1},
        {0,-1},
        {1, 0},
        {-1, 0}
    };

    List<int[]> getNeighboors(int[] curr, int[][] grid) {
        var res = new ArrayList<int[]>();
        for (var m : moves) {
            var i = curr[0] + m[0];
            var j = curr[1] + m[1];

            if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
                res.add(new int[]{i, j});
            } 
        }
        return res;
    }
/*
0 1 0
1 0 1
0 1 0

2

1 1 0
1 1 1
0 1 1
*/
    int find(int x, int[] parr) {
        if (parr[x] != x) parr[x] = find(parr[x], parr);
        return parr[x];
    }

    int union(int x, int y, int[] parr) {
        var root_x = find(x, parr);
        var root_y = find(y, parr);

        if (root_x == x) {
            // curr pos is not connected yet, let's connect and keep the same number os islands
            parr[x] = root_y; // connect with neighboor
            return 0;
        }

        if (root_x == root_y) return 0; // keep the same number os islands

        parr[root_y] = root_x;
        return -1; // union both islands
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        var grid = new int[m][n];

        // (i, j) -> (parrI, parrJ)
        var parr = new int[m*n];
        for (var i = 0; i < parr.length; i++) parr[i] = i; 

        var res = new ArrayList<Integer>();

        var islands = 0;
        for (var pos : positions) {
            var i = pos[0];
            var j = pos[1];

            var idxPos = i * n + j;

            if (grid[i][j] == 0) {
                grid[i][j] = 1;

                var neighboors = getNeighboors(pos, grid);
                if (neighboors.isEmpty()) islands++;
                
                for (var next : neighboors) {
                    islands += union(idxPos, next[0] * n + next[1], parr);
                }
            }

            res.add(islands);
        }
        return res;
    }
}
