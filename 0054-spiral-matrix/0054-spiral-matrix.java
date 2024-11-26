class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int buttom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        while (top < buttom && left < right) {
            for (int i = left; i < right; i++)
                ans.add(matrix[top][i]);
            top++;

            for (int i = top; i < buttom; i++)
                ans.add(matrix[i][right - 1]);
            right--;

            if (top >= buttom || left >= right)
                break;

            for (int i = right - 1; i >= left; i--)
                ans.add(matrix[buttom - 1][i]);
            buttom--;

            for (int i = buttom - 1; i >= top; i--)
                ans.add(matrix[i][left]);
            left++;
        }
        return ans;
    }
}