class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;

        int x = image.length;
        int y = image[0].length;
        int[][] visited = new int[x][y];

        Queue<int[]> queue = new LinkedList();
        dfs(image, visited, queue, sr, sc, image[sr][sc]);

        while (queue.size() != 0) {
            int[] site = (int[]) queue.poll();
            image[site[0]][site[1]] = color;
        }

        return image;
    }

    private void dfs(int[][] image, int[][] visited, Queue queue, int sr, int sc, int color) {
        int x = image.length;
        int y = image[0].length;

        if (x <= sr || y <= sc || sr < 0 || sc < 0 || visited[sr][sc] != 0)
            return;

        if (color != image[sr][sc]) {
            visited[sr][sc] = 2;
            return;
        }

        queue.add(new int[] { sr, sc });
        visited[sr][sc] = 1;

        dfs(image, visited, queue, sr - 1, sc, color);
        dfs(image, visited, queue, sr + 1, sc, color);
        dfs(image, visited, queue, sr, sc - 1, color);
        dfs(image, visited, queue, sr, sc + 1, color);

    }

}