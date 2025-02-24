class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;
        int[][] map = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.MAX_VALUE;
                if (mat[i][j] == 0) {
                    map[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    if (i > 0)
                        min = Math.min(min, map[i - 1][j]);
                    if (j > 0)
                        min = Math.min(min, map[i][j - 1]);
                    map[i][j] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
                }
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    map[i][j] = 0;
                } else {
                    int min = map[i][j];
                    if (i < x - 1)
                        min = Math.min(min, map[i + 1][j]);
                    if (j < y - 1)
                        min = Math.min(min, map[i][j + 1]);
                    map[i][j] = min == map[i][j] ? map[i][j] : min + 1;
                }
            }
        }
        return map;
    }
}