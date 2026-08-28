class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) Arrays.fill(dp[i], -1);
        return findMinDis (0, 0, word1, word2, dp);
    }

    public int findMinDis (int idx1, int idx2, String word1, String word2, int[][] dp) {
        if (idx2 == word2.length()) return word1.length() - idx1;
        if (idx1 == word1.length()) return word2.length() - idx2;
        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if (word1.charAt(idx1) != word2.charAt(idx2)) {
            int insert = 1 + findMinDis (idx1, idx2 + 1, word1, word2, dp);
            int delete = 1 + findMinDis (idx1 + 1, idx2, word1, word2, dp);
            int replace = 1 + findMinDis (idx1 + 1, idx2 + 1, word1, word2, dp);

            return dp[idx1][idx2] = Math.min(replace, Math.min (insert, delete));
        }

        return dp[idx1][idx2] = findMinDis (idx1 + 1, idx2 + 1, word1, word2, dp);
    }
}