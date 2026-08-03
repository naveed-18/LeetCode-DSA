class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        // int[][] dp = new int[n][2];
        // for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // int result = stoneGame (0, stoneValue, n, 1, dp);

        int result = stoneGameTabulation (stoneValue, n);
        if (result > 0) return "Alice";
        else if (result < 0) return "Bob";
        return "Tie";
    }

    public int stoneGame (int idx, int[] stoneValue, int n, int isAliceTurn, int[][] dp) {
        if (idx == n) {
            return 0;
        }

        if (dp[idx][isAliceTurn] != -1) return dp[idx][isAliceTurn];

        int ans = isAliceTurn == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (idx + i < n) {
                sum += stoneValue[idx + i];
                if (isAliceTurn == 1) {
                    ans = Math.max (
                        ans,
                        sum + stoneGame (idx + i + 1, stoneValue, n, 0, dp)
                    );
                } else {
                    ans = Math.min (
                        ans,
                        -sum + stoneGame (idx + i + 1, stoneValue, n, 1, dp)
                    );
                }
            }
        }

        return dp[idx][isAliceTurn] = ans;
    }

    public int stoneGameTabulation (int[] stoneValue, int n) {
        int[][] dp = new int[n + 1][2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int isAliceTurn = 0; isAliceTurn < 2; isAliceTurn++) {
                int ans = isAliceTurn == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                int sum = 0;
                for (int i = 0; i < 3; i++) {
                    if (idx + i < n) {
                        sum += stoneValue[idx + i];
                        if (isAliceTurn == 1) {
                            ans = Math.max (
                                ans,
                                sum + dp[idx + i + 1][0]
                            );
                        } else {
                            ans = Math.min (
                                ans,
                                -sum + dp[idx + i + 1][1]
                            );
                        }
                    }
                }
                dp[idx][isAliceTurn] = ans; 
            }
        }

        return dp[0][1];
    }
}