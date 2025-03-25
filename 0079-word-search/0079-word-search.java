class Solution {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (dfs(board, visited, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int index) {
        if (word.length() == index) {
            return true;
        }

        if (x < 0 || y < 0 ||
                x >= board.length || y >= board[0].length ||
                visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        index++;
        visited[x][y] = true;

        if (dfs(board, visited, x + 1, y, word, index) ||
                dfs(board, visited, x - 1, y, word, index) ||
                dfs(board, visited, x, y + 1, word, index) ||
                dfs(board, visited, x, y - 1, word, index)) {
            return true;
        }

        visited[x][y] = false;
        return false;
    }
}