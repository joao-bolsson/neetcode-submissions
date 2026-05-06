/*

union find alg


0 -> 1

3 -> 4

2 -> 3

groups = n

every time I union and create a group
    - increment groups
    - merge different groups: decrement groups

stop when groups == 1: return time

parr = [1, 1, 4, 4, 4, 1, ..., n-1]

*/
class Solution {
/*

parr=[1, 1, 2, 3, 4, ...]
      0, 1, 2, 3, 4,
*/
    int find(int x, int[] parr) {
        while (parr[x] != x) {
            x = find(parr[x], parr);
        }
        return x;
    }

    int union(int x, int y, int[] parr) {
        var root_x = find(x, parr);
        var root_y = find(y, parr);

        if (root_x == root_y) return 0; // they are on the same group already
        // they are on different groups: connect groups
        parr[root_y] = root_x;
        return 1;
    }

    public int earliestAcq(int[][] logs, int n) {
        // sort logs according with timestamps: asc order
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        var parr = new int[n];
        for (var i = 0; i < n; i++) parr[i] = i;

        var groups = n;

        for (var log : logs) {
            groups -= union(log[1], log[2], parr);
            if (groups == 1) return log[0];
        }
        return -1;
    }
}
