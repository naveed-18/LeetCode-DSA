class Solution {
    public int dominantIndex(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int maxiIdx = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (maxi < nums[i]) {
                maxi = nums[i];
                maxiIdx = i;
            }
        }

        for (int num : nums) {
            if (num == maxi) continue;
            if (num * 2 > maxi) return -1;
        }

        return maxiIdx;
    }
}