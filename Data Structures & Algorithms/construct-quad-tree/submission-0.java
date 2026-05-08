/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    Node node(int[] start, int[] end, int[][] grid) {
        var root = new Node();

        var val = grid[start[0]][start[1]];
        var needSplit = false;
        OUT_LOOP: for (var i = start[0]; i < end[0]; i++) {
            for (var j = start[1]; j < end[1]; j++) {
                needSplit = grid[i][j] != val;
                if (needSplit) break OUT_LOOP;
            }
        }

        var isLeaf = !needSplit;
        root.isLeaf = isLeaf;

        var mid = new int[]{(start[0] + end[0]) / 2, (start[1] + end[1]) / 2};
        if (needSplit) {
            // start = (0,0) end = (8,8) mid = 4,4
            root.val = false; // arbitrary
            root.topLeft = node(start, mid, grid);
            root.topRight = node(new int[]{start[0], mid[1]}, new int[]{mid[0], end[1]}, grid);
            root.bottomLeft = node(new int[]{mid[0], start[1]}, new int[]{end[0], mid[1]}, grid);
            root.bottomRight = node(mid, end, grid);
        } else {
            root.val = val == 1 ? true : false;
        }

        return root;
    }

    public Node construct(int[][] grid) {
        var n = grid.length;
        return node(new int[]{0,0}, new int[]{n, n}, grid);
    }
}