class Solution {

    int[][] moves = new int[][] {
        {1, 2},
        {2, 1},
        {2, -1},
        {1, -2},
        {-1, -2},
        {-2, -1},
        {-2, 1},
        {-1, 2}
    };

    record Cell(int x, int y) {}

    public int minKnightMoves(int x, int y) {
        var q = new LinkedList<Cell>();
        q.add(new Cell(0, 0)); // start coord

        var visited = new HashSet<Cell>();

        var steps = 0;
        while (!q.isEmpty()) {

            var size = q.size();
            while (size-- > 0) { // check all from same level
                var cell = q.poll();

                if (cell.x == Math.abs(x) && cell.y == Math.abs(y)) return steps;

                if (visited.contains(cell)) continue;
                visited.add(cell);

                for (var m : moves) {
                    // select moves based on current pos and target
                    var next = new Cell(Math.abs(cell.x + m[0]), Math.abs(cell.y + m[1]));
                    if (visited.contains(next)) continue;
                    q.add(next);
                }
            }

            steps++;
        }
        return -1;
    }
}
