class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (image[sr][sc] == color)
            return image;

        int x = image.length;
        int y = image[0].length;
        int[][] visited = new int[x][y];

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] { sr, sc });

        while (queue.size() != 0) {
            int[] current = (int[]) queue.poll();
            int r = current[0];
            int c = current[1];

            image[r][c] = color;

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newRow < x && newCol >= 0 && newCol < y &&
                        image[newRow][newCol] == originalColor) {
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }

        return image;
    }
}