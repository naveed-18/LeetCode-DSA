class Solution {
    public int numDistinct(String s, String t) {
        // APPROACH 1 :
        // return dfsPath (0, 0, s, t);

        // APPROACH 2 :
        // int n1 = s.length(), n2 = t.length();
        // int[][] dp = new int[n1 + 1][n2 + 1];
        // for (int i = 0; i <= n1; i++) Arrays.fill(dp[i], -1);

        // return memoization (0, 0, s, t, dp);

        // APPROACH 3 : 
        return tabulation (s, t);
    }

    public int dfsPath (int i, int j, String s, String t) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take += dfsPath (i + 1, j + 1, s, t);
        }
        return take + dfsPath (i + 1, j, s, t);
    }

    public int memoization(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take += memoization (i + 1, j + 1, s, t, dp);
        }
        return dp[i][j] = take + memoization (i + 1, j, s, t, dp);
    }

    public int tabulation (String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) dp[i][n2] = 1;

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int take = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    take += dp[i + 1][j + 1];
                }
                dp[i][j] = take + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
}