class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (!(validRow(board, row, col) && validCol(board, row, col) && validSquare(board, row, col))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validRow(char[][] board, int col, int row) {
        if (board[col][row] == '.')
            return true;
        int target = board[col][row] - '0';

        for (int i = 0; i < 9; i++) {
            if (i != row && board[col][i] - '0' == target)
                return false;
        }
        return true;
    }

    private boolean validCol(char[][] board, int col, int row) {
        if (board[col][row] == '.')
            return true;
        int target = board[col][row] - '0';

        for (int i = 0; i < 9; i++) {
            if (i != col && board[i][row] - '0' == target)
                return false;
        }
        return true;
    }

    private boolean validSquare(char[][] board, int col, int row) {

        if (board[col][row] == '.')
            return true;
        int target = board[col][row] - '0';

        int lv_col = col / 3;
        int lv_row = row / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cur_col = lv_col * 3 + i;
                int cur_row = lv_row * 3 + j;

                if (col == cur_col && row == cur_row)
                    continue;
                if (board[cur_col][cur_row] - '0' == target)
                    return false;
            }
        }
        return true;
    }
}