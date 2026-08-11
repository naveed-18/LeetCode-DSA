class Solution {
    public int tribonacci(int n) {
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, - 1);
        // return tribonacciMemo(n, dp);

        return tribonacciTab(n);
    }

    public int tribonacciTab (int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
    public int tribonacciMemo(int n, int[] dp) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != -1) return dp[n];

        return dp[n] = tribonacciMemo(n - 1, dp) + 
            tribonacciMemo(n - 2, dp) + tribonacciMemo(n - 3, dp);
    }
}