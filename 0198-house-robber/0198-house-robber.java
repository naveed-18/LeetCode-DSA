class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memo (n - 1, nums, dp);
    }

    public int memo (int idx, int[] nums, int[] dp) {
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + memo (idx - 2, nums, dp);
        int notPick = memo (idx - 1, nums, dp);

        return dp[idx] = Math.max (pick, notPick);
    }
}