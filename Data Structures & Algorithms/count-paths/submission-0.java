class Solution {

    int[][] moves = new int[][]{
        {1, 0},
        {0, 1}
    };

    int dfs(int[][] dp, int i, int j) {
        if (i >= dp.length || j >= dp[i].length) return 0;
        if (i == dp.length - 1 && j == dp[i].length - 1) return 1;
        
        if (dp[i][j] != -1) return dp[i][j]; // visited

        var curr = 0;
        for (var m : moves) {
            curr += dfs(dp, i + m[0], j + m[1]);
        }

        dp[i][j] = curr; // visit
        return curr;
    }

    public int uniquePaths(int m, int n) {
        var dp = new int[m][n];
        for (var i = 0; i < m; i++) for (var j = 0; j < n; j++) dp[i][j] = -1; // not visited

        return dfs(dp, 0, 0);
    }
}
