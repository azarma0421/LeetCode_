class Solution {
    public int countServers(int[][] grid) {
        int[] col = new int[grid.length];
        int[] row = new int[grid[0].length];
        int connect = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    col[i]++;
                    row[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (col[i] > 1 || row[j] > 1))
                    connect++;
            }
        }

        return connect;
    }
}