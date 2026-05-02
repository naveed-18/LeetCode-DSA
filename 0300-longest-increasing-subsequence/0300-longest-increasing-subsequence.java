class Solution {
    public int lengthOfLIS(int[] nums) {
        // return lis (0, nums, nums.length, -1);
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return lisMemo (0, nums, n, -1, dp);
    }

    public int lis (int idx, int[] nums, int n, int lastIdx) {
        if (idx >= n) return 0;
        int notTake = lis(idx + 1, nums, n, lastIdx);
        int take = 0;
        if (lastIdx == -1 || nums[lastIdx] < nums[idx]) {
            take = 1 + lis (idx + 1, nums, n, idx);
        }
        return Math.max(take, notTake);
    }

    public int lisMemo (int idx, int[] nums, int n, int lastIdx, int[][] dp) {
        if (idx >= n) return 0;
        if (dp[idx][lastIdx + 1] != -1) return dp[idx][lastIdx + 1];
        int notTake = lisMemo (idx + 1, nums, n, lastIdx, dp);
        int take = 0;
        if (lastIdx == -1 || nums[lastIdx] < nums[idx]) {
            take = 1 + lisMemo (idx + 1, nums, n, idx, dp);
        }
        return dp[idx][lastIdx + 1] = Math.max(take, notTake);
    }
}