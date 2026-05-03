class Solution {

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    class Trie {
        Node root = new Node();

        void add(String w) {
            var curr = root;

            for (var letter : w.toCharArray()) {
                if (!curr.children.containsKey(letter)) curr.children.put(letter, new Node());
                curr = curr.children.get(letter);
            }
            curr.isWord = true;
        }
    }

    int[][] moves = new int[][] {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

/*

["o","a","a","n"],
["e","t","a","e"],
["i","h","k","r"],
["i","f","l","v"]
*/
    void backtrack(int i, int j, char[][] board, boolean[][] visited, Node curr, StringBuilder currWord, Set<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return; // out of bounds
        if (visited[i][j]) return;
        
        var l = board[i][j];
        if (!curr.children.containsKey(l)) return;
        var next = curr.children.get(l);

        currWord.append(l);
        if (next.isWord) {
            res.add(currWord.toString());
        }

        visited[i][j] = true;
        for (var m : moves) {
            backtrack(i + m[0], j + m[1], board, visited, next, currWord, res);
        }
        visited[i][j] = false;
        currWord.deleteCharAt(currWord.length() - 1); // undo
    }

    public List<String> findWords(char[][] board, String[] words) {
        var trie = new Trie();
        for (var w : words) trie.add(w);

        var visited = new boolean[board.length][board[0].length];

        var res = new HashSet<String>();

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[i].length; j++) {
                if (trie.root.children.containsKey(board[i][j])) {
                    // check if some word can be found from this cell
                    backtrack(i, j, board, visited, trie.root, new StringBuilder(), res);
                }
            }
        }

        return new ArrayList<>(res);
    }
}
