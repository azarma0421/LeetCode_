class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int index = 0;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, row, col, board, visited, word, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int row, int col, char[][] board, boolean[][] visited, String word, int index) {
        if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || index >= word.length()
                || board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;
        index++;

        if (index == word.length()) {
            return true;
        }

        if (
            dfs(x + 1, y, row, col, board, visited, word, index) ||
            dfs(x - 1, y, row, col, board, visited, word, index) ||
            dfs(x, y + 1, row, col, board, visited, word, index) ||
            dfs(x, y - 1, row, col, board, visited, word, index)){
                return true;
            }
        visited[x][y] = false;
        return false;
    }
}