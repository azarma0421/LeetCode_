class Solution {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (backtrack(word, i, j, board, visited, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(String word, int x, int y, char[][] board, boolean[][] visited, int matched) {
        if (word.length() == matched)
            return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y])
            return false;
        if (word.charAt(matched) == board[x][y]) {
            matched++;
            visited[x][y] = true;
            if (backtrack(word, x + 1, y, board, visited, matched) || backtrack(word, x - 1, y, board, visited, matched) ||
                    backtrack(word, x, y + 1, board, visited, matched) || backtrack(word, x, y - 1, board, visited, matched)) {
                return true;
            }
            matched--;
            visited[x][y] = false;
        }
        return false;
    }
}