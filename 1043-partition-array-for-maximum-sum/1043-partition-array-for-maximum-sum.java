class Solution {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        // return partitionArrayMaxSum (0, nums, k);

        int n = nums.length;
        Integer[] dp = new Integer[n];
        return partitionArrayMaxSumMemo (0, nums, k, dp);
    }

    public int partitionArrayMaxSumMemo (int i, int[] nums, int k, Integer[] dp) {
        if (i == nums.length) return 0;
        if (dp[i] != null) return dp[i];

        int maxValue = nums[i];
        int maxSum = Integer.MIN_VALUE;
        for (int j = i; j < i + k && j < nums.length; j++) {
            maxValue = Math.max(maxValue, nums[j]);
            maxSum = Math.max(maxSum, (maxValue * (j - i + 1)) + partitionArrayMaxSumMemo (j + 1, nums, k, dp));
        }

        return dp[i] = maxSum;
    }

    public int partitionArrayMaxSum (int i, int[] nums, int k) {
        if (i == nums.length) return 0;

        int maxValue = nums[i];
        int maxSum = Integer.MIN_VALUE;
        for (int j = i; j < i + k && j < nums.length; j++) {
            maxValue = Math.max(maxValue, nums[j]);
            maxSum = Math.max(maxSum, (maxValue * (j - i + 1)) + partitionArrayMaxSum (j + 1, nums, k));
        }

        return maxSum;
    }
}