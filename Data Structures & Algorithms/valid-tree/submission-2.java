class Solution {

    int find(int a, int[] parr) {
        if (a != parr[a]) {
            parr[a] = find(parr[a], parr); // path compression
        }
        return parr[a];
    }

    boolean union(int a, int b, int[] parr) {
        var root_a = find(a, parr);
        var root_b = find(b, parr);

        if (root_a == root_b) return false;

        parr[root_b] = root_a;
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        var parr = new int[n]; // n = 4 -> [0, 1, 2, 3]
        for (int i = 0; i < n; i++) parr[i] = i;

        for (var edge : edges) {
            if (!union(edge[0], edge[1], parr)) return false; // cycle
        }

        // Instead of checking if parr[i] == parr[0], check if all nodes share the same root
        int root = find(0, parr);
        for (var i = 1; i < n; i++) if (find(i, parr) != root) return false;

        return true;
    }
}

