class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int down = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        while (left < right && top < down) {
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for (int j = top; j < down; j++) {
                ans.add(matrix[j][right - 1]);
            }
            right--;

            if (left >= right || top >= down)
                break;

            for (int i = right - 1; i >= left; i--) {
                ans.add(matrix[down - 1][i]);
            }
            down--;

            for (int j = down - 1; j >= top; j--) {
                ans.add(matrix[j][left]);
            }
            left++;
        }
        return ans;

    }
}