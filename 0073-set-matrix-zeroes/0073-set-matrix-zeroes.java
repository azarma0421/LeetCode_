class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] m_up = new int[row][col];
        int[][] m_down = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    int tem_i = i;
                    int tem_j = j;
                    while (tem_i >= 0) {
                        m_up[tem_i][j] = 0;
                        tem_i--;
                    }
                    while (tem_j >= 0) {
                        m_up[i][tem_j] = 0;
                        tem_j--;
                    }
                }else{
                    m_up[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    int tem_i = i;
                    int tem_j = j;
                    while (tem_i < row) {
                        m_down[tem_i][j] = 0;
                        tem_i++;
                    }
                    while (tem_j < col) {
                        m_down[i][tem_j] = 0;
                        tem_j++;
                    }
                }else{
                    m_down[i][j] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m_up[i][j] == 0 || m_down[i][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}