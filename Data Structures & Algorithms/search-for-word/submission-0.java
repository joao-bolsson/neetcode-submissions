class Solution {

    int[][] moves = {
        {0,1}, // right
        {0,-1}, // left
        {-1,0}, // up
        {1,0} // down
    };

    boolean isOutOfBounds(int l, int c, char[][] board) {
        return l < 0 || l >= board.length || c < 0 || c >= board[l].length;
    }

    boolean backtrack(int l, int c, int idx, String word, char[][] board, boolean[][] visited) {
        if (idx >= word.length()) return true;

        for (var move : moves) {
            var nL = l + move[0];
            var nC = c + move[1];

            if (isOutOfBounds(nL, nC, board)) continue;
            if (visited[nL][nC]) continue;
            if (board[nL][nC] != word.charAt(idx)) continue;

            visited[nL][nC] = true;
            if (backtrack(nL, nC, idx + 1, word, board, visited)) return true;
            visited[nL][nC] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (var l = 0; l < board.length; l++) {
            for (var c = 0; c < board[l].length; c++) {
                if (board[l][c] == word.charAt(0)) {
                    var visited = new boolean[board.length][board[l].length];
                    visited[l][c] = true;
                    if (backtrack(l, c, 1, word, board, visited)) return true;
                }
            }
        }
        return false;
    }
}