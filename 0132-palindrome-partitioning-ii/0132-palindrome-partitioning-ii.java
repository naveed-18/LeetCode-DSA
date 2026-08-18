class Solution {
    public int minCut(String s) {
        // return palindromePartitioning (0, s) - 1;

        int n = s.length();
        Integer[] dp = new Integer[n];
        return palindromePartitioningMemo (0, s, dp) - 1;
    }

    public int palindromePartitioningMemo (int i, String s, Integer[] dp) {
        if (i == s.length()) return 0;
        if (dp[i] != null) return dp[i];

        int currMinCuts = Integer.MAX_VALUE;
        for (int k = i; k < s.length(); k++) {
            if (isPalindrome (s, i, k)) {
                currMinCuts = Math.min (currMinCuts, 1 + palindromePartitioningMemo (k + 1, s, dp));
            }
        }

        return dp[i] = currMinCuts;
    }

    public int palindromePartitioning (int i, String s) {
        if (i == s.length()) return 0;

        int currMinCuts = Integer.MAX_VALUE;
        for (int k = i; k < s.length(); k++) {
            if (isPalindrome (s, i, k)) {
                currMinCuts = Math.min (currMinCuts, 1 + palindromePartitioning (k + 1, s));
            }
        }

        return currMinCuts;
    }

    public boolean isPalindrome (String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}