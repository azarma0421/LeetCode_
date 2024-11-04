class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    sink(i, j, grid);
                }
            }
        }
        return islands;
    }

    private void sink(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        sink(i + 1, j, grid);
        sink(i - 1, j, grid);
        sink(i, j + 1, grid);
        sink(i, j - 1, grid);
    }
}