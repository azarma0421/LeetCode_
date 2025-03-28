class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int m, int n, int height) {
        if (m < 0 || n < 0 ||
                m >= matrix.length || n >= matrix[0].length ||
                visited[m][n] || matrix[m][n] < height)
            return;
        visited[m][n] = true;
        dfs(matrix, visited, m + 1, n, matrix[m][n]);
        dfs(matrix, visited, m - 1, n, matrix[m][n]);
        dfs(matrix, visited, m, n + 1, matrix[m][n]);
        dfs(matrix, visited, m, n - 1, matrix[m][n]);

    }
}