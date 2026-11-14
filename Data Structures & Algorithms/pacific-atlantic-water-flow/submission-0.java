class Solution {

    int[][] moves = new int[][]{
        {0, 1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    void dfs(int l, int c, boolean[][] visited, int[][] heights) {
        if (visited[l][c]) return;
        visited[l][c] = true;

        for (var m : moves) {
            var nL = l + m[0];
            var nC = c + m[1];

            if (nL < 0 || nL >= heights.length || nC < 0 || nC >= heights[nL].length) continue;

            if (heights[nL][nC] >= heights[l][c]) dfs(nL, nC, visited, heights);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var lines = heights.length;
        var cols = heights[0].length;

        var pacific = new boolean[lines][cols];
        var atlantic = new boolean[lines][cols];

        for (var c = 0; c < heights[0].length; c++) {
            dfs(0, c, pacific, heights);
            dfs(heights.length - 1, c, atlantic, heights);
        }

        for (var l = 0; l < heights.length; l++) {
            dfs(l, 0, pacific, heights);
            dfs(l, heights[l].length - 1, atlantic, heights);
        }

        var res = new ArrayList<List<Integer>>();
        for (var l = 0; l < heights.length; l++) {
            for (var c = 0; c < heights[l].length; c++) {
                if (pacific[l][c] && atlantic[l][c]) res.add(Arrays.asList(l, c));
            }
        }
        return res;
    }
}
