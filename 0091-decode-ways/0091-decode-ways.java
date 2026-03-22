class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return countDecodeString (0, s, n, dp);
    }

    public int countDecodeString (int idx, String s, int n, int[] dp) {
        if (idx == n) return 1;

        if (s.charAt(idx) == '0') return 0;
        if (dp[idx] != -1) return dp[idx];

        int count = countDecodeString (idx + 1, s, n, dp);

        if (idx + 1 < n) {
            int num = Integer.parseInt(s.substring(idx, idx + 2));
            if (num >= 10 && num <= 26) count += countDecodeString (idx + 2, s, n, dp);
        }

        return dp[idx] = count;
    }
}