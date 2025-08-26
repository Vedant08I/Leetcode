class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[0];

        int m = mat.length, n = mat[0].length;
        int len = m * n;
        int[] result = new int[len];

        int row = 0, col = 0;

        for (int i = 0; i < len; i++) {
            result[i] = mat[row][col];

            if ((row + col) % 2 == 0) { // moving up-right
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else { row--; col++; }
            } else { // moving down-left
                if (row == m - 1) col++;
                else if (col == 0) row++;
                else { row++; col--; }
            }
        }
        return result;
    }
}