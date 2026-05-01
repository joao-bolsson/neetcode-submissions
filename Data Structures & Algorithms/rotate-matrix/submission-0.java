/*

1 -> 3 -> 9 -> 7 -> null / 1 (starting point)

need to jump the number of elements in a row - 2

[0][0] -> [0][2] -> [2][2] -> [2][0]

2 -> 6 -> 8 -> 4

[0][1] -> [1][2] -> [2][1] -> [1][0]

[i][j]

i >= 0 && i <= row.length - 2

jumps = row.length - 2


i = 0, j = 0

curr = [0][0] // start with [0][0] and saves it as curr

1. 
2. go to the next [0][2] and saves it as next
3. insert at [0][2] the value of curr
4. curr = next

how to define next? 
don't now yet, but let's create a function int[] next(int currI, currJ);
*/

class Solution {

    int[] next(int i, int j, int l, int[][] matrix) {
        int n = matrix.length;
        return new int[]{j, n - 1 - i}; // Target position for value at [i][j]
    }

    public void rotate(int[][] matrix) {
        // how many times do I have to "enter" in the image to rotate each "layer"?
        int layers = matrix[0].length / 2;

        for (int l = 0; l < layers; l++) {

            int lastCol = matrix[l].length - l - 1;

            for (int i = l, j = l; j <= lastCol - 1; j++) {
                int[] currIndexes = new int[]{i, j};
                int[] nextIndexes = next(i, j, l, matrix);

                int curr = matrix[currIndexes[0]][currIndexes[1]];
                int nextValue = matrix[nextIndexes[0]][nextIndexes[1]];

                while (nextIndexes[0] != i || nextIndexes[1] != j) {
                    matrix[nextIndexes[0]][nextIndexes[1]] = curr;

                    curr = nextValue;

                    nextIndexes = next(nextIndexes[0], nextIndexes[1], l, matrix);
                    nextValue = matrix[nextIndexes[0]][nextIndexes[1]];
                }

                matrix[i][j] = curr;
            }
        }
    }
}