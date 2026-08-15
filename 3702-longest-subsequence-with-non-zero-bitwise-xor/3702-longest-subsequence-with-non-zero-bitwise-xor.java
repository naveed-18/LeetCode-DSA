class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int count = 0;
        int n = nums.length;
        for (int num : nums) {
            xor ^= num;
            if (num > 0) count++;
        }
        if (xor != 0) return n;
        if (count == 0) return 0;
        return n - 1;
    }
}