/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

/*

0 0 0 0 0
0 0 0 1 1
0 0 0 0 0
0 1 1 1 1
0 0 0 0 0

start = leftMost - 1
*/

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        var dims = binaryMatrix.dimensions();
        var rows = dims.get(0);
        var cols = dims.get(1);

        var leftMost = cols;
        for (var r = 0; r < rows; r++) {
            for (var c = leftMost - 1; c >= 0; c--) {
                if (binaryMatrix.get(r, c) == 0) break;
                leftMost = c;
            }
        }
        if (leftMost == cols) return -1;
        return leftMost;
    }
}
