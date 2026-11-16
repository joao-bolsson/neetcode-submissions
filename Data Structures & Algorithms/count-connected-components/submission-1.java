/*
pos 0 1 2 3 4
par 0 0 0 3 3

*/

class Solution {

    boolean union(int a, int b, int[] par) {
        var p1 = find(a, par); // 0
        var p2 = find(b, par); // 2

        if (p1 == p2) return true; // already connected

        par[p2] = p1;
        return false;
    }

    int find(int x, int[] par) {
        var p = par[x];

        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    public int countComponents(int n, int[][] edges) {
        var par = new int[n];
        for (var i = 0; i < n; i++) par[i] = i;

        var count = n;

        for (var edge : edges) {
            if (!union(edge[0], edge[1], par)) count--;
        }

        return count;
    }
}
