class Solution {

    record Cell(int l, int c) {}

    List<Cell> getNeighboors(int l, int c, boolean[][] visited, char[][] grid) {
        var neighboors = new ArrayList<Cell>();
        neighboors.add(new Cell(l - 1, c)); // top
        neighboors.add(new Cell(l, c + 1)); // right
        neighboors.add(new Cell(l, c - 1)); // left
        neighboors.add(new Cell(l + 1, c)); // bottom

        return neighboors.stream().filter(cell -> {
            return cell.l >= 0 && cell.l < grid.length 
                && cell.c >= 0 && cell.c < grid[cell.l].length // avoid index out of bounds
                && grid[cell.l][cell.c] == '1' // only land
                && !visited[cell.l][cell.c] // not visited
                && !visitedCells.contains(new Cell(cell.l, cell.c)); // avoid overpositioning
        }).toList();
    }

    Set<Cell> visitedCells = new HashSet<>();

    public int numIslands(char[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        var islands = 0;

        for (var l = 0; l < grid.length; l++) {
            for (var c = 0; c < grid[l].length; c++) {
                if (grid[l][c] == '1' && !visited[l][c]) {
                    islands++;

                    visited[l][c] = true;

                    var neighboors = getNeighboors(l, c, visited, grid);

                    var queue = new LinkedList<Cell>();
                    queue.addAll(neighboors);
                    visitedCells.addAll(neighboors);

                    while (!queue.isEmpty()) {
                        var cell = queue.pop();

                        visited[cell.l][cell.c] = true;

                        neighboors = getNeighboors(cell.l, cell.c, visited, grid);
                        queue.addAll(neighboors);
                        visitedCells.addAll(neighboors);
                    }
                }
            }
        }

        return islands;
    }
}