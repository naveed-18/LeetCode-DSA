class Solution {
    public int climbStairs(int n) {
        // return allPaths (n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoization (n, dp);
    }

    public int allPaths (int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        return allPaths (n - 1) + allPaths (n - 2);
    }

    public int memoization (int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = memoization (n - 1, dp) + memoization (n - 2, dp);
    }
}