class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return tabulationSpaceOpti (n, nums);
    }

    public int recursive(int idx, int[] nums) {
        if (idx == 0) return nums[idx];
        if (idx < 0) return 0;
        int pick = nums[idx] + recursive(idx - 2, nums);
        int notPick = 0 + recursive(idx - 1, nums);
        return Math.max(pick, notPick);
    }

    public int memoization (int idx, int[] nums, int[] dp) {
        if (idx == 0) return nums[idx];
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];
        int pick = nums[idx] + memoization(idx - 2, nums, dp);
        int notPick = 0 + memoization(idx - 1, nums, dp);
        return dp[idx] = Math.max(pick, notPick);
    }

    public int tabulation (int n, int[] nums, int[] dp) {
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += dp[i - 2];
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    public int tabulationSpaceOpti (int n, int[] nums) {
        int prev2 = 0,
            prev1 = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;
            int notPick = 0 + prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}