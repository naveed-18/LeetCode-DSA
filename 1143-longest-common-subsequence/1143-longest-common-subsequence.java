class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        // return allPaths (n1 - 1, n2 - 1, text1, text2);

        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) Arrays.fill(dp[i], -1);
        return lcsMemo (n1 - 1, n2 - 1, text1, text2, dp);
    }

    public int allPaths (int idx1, int idx2, String text1, String text2) {
        if (idx1 < 0 || idx2 < 0) return 0;

        int notTake = Math.max(allPaths (idx1 - 1, idx2, text1, text2),
            allPaths (idx1, idx2 - 1, text1, text2));
        int take = 0;
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            take = 1 + allPaths (idx1 - 1, idx2 - 1, text1, text2);
        }

        return Math.max(notTake, take);
    }

    public int lcsMemo (int idx1, int idx2, String text1, String text2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int notTake = Math.max(lcsMemo (idx1 - 1, idx2, text1, text2, dp),
            lcsMemo (idx1, idx2 - 1, text1, text2, dp));
        int take = 0;
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            take = 1 + lcsMemo (idx1 - 1, idx2 - 1, text1, text2, dp);
        }

        return dp[idx1][idx2] = Math.max(notTake, take);
    }    
}