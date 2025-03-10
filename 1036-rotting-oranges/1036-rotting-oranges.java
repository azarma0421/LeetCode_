class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int freshOramges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.add(new int[] { i, j });
                else if (grid[i][j] == 1)
                    freshOramges++;
            }
        }
        System.out.println("freshOramges " + freshOramges);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    queue.add(new int[] { x - 1, y });
                    grid[x - 1][y] = 2;
                    freshOramges--;
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    queue.add(new int[] { x, y - 1 });
                    grid[x][y - 1] = 2;
                    freshOramges--;
                }
                if (x < grid.length - 1 && grid[x + 1][y] == 1) {
                    queue.add(new int[] { x + 1, y });
                    grid[x + 1][y] = 2;
                    freshOramges--;
                }
                if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
                    queue.add(new int[] { x, y + 1 });
                    grid[x][y + 1] = 2;
                    freshOramges--;
                }
            }
            if (!queue.isEmpty())
                time++;
        }
        return freshOramges == 0 ? time : -1;
    }
}