class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix[0].length - 1;
        while (left < right && top < bottom) {
            for (int i = 0; i < right-left; i++) {
                int tem = matrix[top][left+i];
                matrix[top][left+i] = matrix[right - i][left];
                matrix[right - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tem;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}