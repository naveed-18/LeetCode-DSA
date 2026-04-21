class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = s.length(), n2 = p.length();
        // APPROACH 1 :
        // return dfsPath (n1 - 1, n2 - 1, s, p);

        // APPROACH 2 :
        Boolean[][] dp = new Boolean[n1][n2];
        return memoization (n1 - 1, n2 - 1, s, p, dp);
    }

    public boolean dfsPath (int i, int j, String s, String p) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (p.charAt(j) == '*') {
            return dfsPath (i - 1, j, s, p) || dfsPath (i, j - 1, s, p);
        } else if (p.charAt(j) == '?') {
            return dfsPath (i - 1, j - 1, s, p);
        } else if (s.charAt(i) == p.charAt(j)) {
            return dfsPath (i - 1, j - 1, s, p);
        } 
        return false;
    }

    public boolean memoization (int i, int j, String s, String p, Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (p.charAt(j) == '*') {
            return dp[i][j] = memoization (i - 1, j, s, p, dp) || memoization (i, j - 1, s, p, dp);
        } else if (p.charAt(j) == '?') {
            return dp[i][j] = memoization (i - 1, j - 1, s, p, dp);
        } else if (s.charAt(i) == p.charAt(j)) {
            return dp[i][j] = memoization (i - 1, j - 1, s, p, dp);
        } 
        return dp[i][j] = false;
    }
}