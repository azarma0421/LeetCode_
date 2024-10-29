class Solution {
    public int numIslands(char[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        int islands = 0;
        int[][] visited = new int[x][y];
        Queue queue = new LinkedList();

        int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    islands++;
                    queue.add(new int[] { i, j });
                    while (queue.size() != 0) {
                        int[] current = (int[]) queue.poll();
                        for (int[] dir : direction) {
                            int newX = current[0] + dir[0];
                            int newY = current[1] + dir[1];
                            if (newX >= 0 && newX < x && newY >= 0 && newY < y
                                    && visited[newX][newY] != 1 && grid[newX][newY] == '1') {
                                queue.add(new int[] { newX, newY });
                                visited[newX][newY] = 1;
                            }
                        }
                    }
                }
                visited[i][j] = 1;
            }
        }

        return islands;
    }
}