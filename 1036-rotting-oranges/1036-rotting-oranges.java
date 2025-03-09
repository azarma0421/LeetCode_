class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotAdj(grid, i, j, 2);
                }
            }
        }

        int minutes = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    System.out.println("=== ");
                    System.out.println("i= " + i);
                    System.out.println("j= " + j);
                    return -1;
                }
                minutes = Math.max(minutes, grid[i][j]);
            }
        }
        return minutes - 2;
    }

    private void rotAdj(int[][] grid, int i, int j, int minute) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] == 0 ||
                (1 < grid[i][j] && grid[i][j] < minute)) {
            return;
        } else {

            grid[i][j] = minute;
            rotAdj(grid, i + 1, j, minute + 1);
            rotAdj(grid, i - 1, j, minute + 1);
            rotAdj(grid, i, j + 1, minute + 1);
            rotAdj(grid, i, j - 1, minute + 1);
        }
    }
}