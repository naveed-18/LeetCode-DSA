class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;


        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i];
        }

        // return stoneGame (0, n - 1, prefixSum);

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        return stoneGameMemo (0, n - 1, prefixSum, dp);
    }

     public int stoneGameMemo (int i, int j, int[] prefixSum, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
         
        int maxScore = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            int leftSum = i == 0 ? prefixSum[k] : prefixSum[k] - prefixSum[i - 1];
            int rightSum = prefixSum[j] - prefixSum[k];

            if (rightSum > leftSum) {
                maxScore = Math.max (maxScore, leftSum + stoneGameMemo (i, k, prefixSum, dp));
            } else if (rightSum < leftSum) {
                maxScore = Math.max (maxScore, rightSum + stoneGameMemo (k + 1, j, prefixSum, dp));
            } else {
                maxScore = Math.max (
                    maxScore, 
                    rightSum + Math.max(
                        stoneGameMemo (i, k, prefixSum, dp),
                        stoneGameMemo (k + 1, j, prefixSum, dp)
                    )
                );
            }
        }

        return dp[i][j] = maxScore;
    }

    public int stoneGame (int i, int j, int[] prefixSum) {
        if (i == j) return 0;

        int maxScore = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            int leftSum = i == 0 ? prefixSum[k] : prefixSum[k] - prefixSum[i - 1];
            int rightSum = prefixSum[j] - prefixSum[k];

            if (rightSum > leftSum) {
                maxScore = Math.max (maxScore, leftSum + stoneGame (i, k, prefixSum));
            } else if (rightSum < leftSum) {
                maxScore = Math.max (maxScore, rightSum + stoneGame (k + 1, j, prefixSum));
            } else {
                maxScore = Math.max (
                    maxScore, 
                    rightSum + Math.max(
                        stoneGame (i, k, prefixSum),
                        stoneGame (k + 1, j, prefixSum)
                    )
                );
            }
        }

        return maxScore;
    }
}