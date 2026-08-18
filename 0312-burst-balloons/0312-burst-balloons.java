class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }

        // return burstBalloons (1, n, nums);

        // Integer[][] dp = new Integer[n + 1][n + 1];
        // return burstBalloonsMemo (1, n, nums, dp);

        return burstBalloonsTab (nums, n);
    }

    public int burstBalloonsTab (int[] nums, int n) {
        int m = nums.length;
        int[][] dp = new int[m][m];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int maxTotalCoins = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int currTotalCoins = (nums[i - 1] * nums[k] * nums[j + 1]);
                    currTotalCoins += dp[i][k - 1] + dp[k + 1][j];

                    maxTotalCoins = Math.max (maxTotalCoins, currTotalCoins);
                }
                dp[i][j] = maxTotalCoins;
            }
        }

        return dp[1][n];
    }

    public int burstBalloonsMemo (int i, int j, int[] nums, Integer[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != null) return dp[i][j];

        int maxTotalCoins = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int currTotalCoins = (nums[i - 1] * nums[k] * nums[j + 1]) +
                burstBalloonsMemo (i, k - 1, nums, dp) + burstBalloonsMemo (k + 1, j, nums, dp);

            maxTotalCoins = Math.max (maxTotalCoins, currTotalCoins);
        }

        return dp[i][j] = maxTotalCoins;
    }

    public int burstBalloons (int i, int j, int[] nums) {
        if (i > j) return 0;

        int maxTotalCoins = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int currTotalCoins = (nums[i - 1] * nums[k] * nums[j + 1]) +
                burstBalloons (i, k - 1, nums) + burstBalloons (k + 1, j, nums);

            maxTotalCoins = Math.max (maxTotalCoins, currTotalCoins);
        }

        return maxTotalCoins;
    }
}