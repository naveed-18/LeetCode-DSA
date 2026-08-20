class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSquareSide = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new  int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxSquareSide = Math.max(maxSquareSide, dp[i][0]);
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxSquareSide = Math.max(maxSquareSide, dp[0][j]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int curr = matrix[i][j] == '1' ? 1 : 0;
                if (curr == 0) continue;
                
                int minSide = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                dp[i][j] = minSide + curr;

                maxSquareSide = Math.max(maxSquareSide, dp[i][j]);
            }
        }

        return maxSquareSide * maxSquareSide;
    }
}