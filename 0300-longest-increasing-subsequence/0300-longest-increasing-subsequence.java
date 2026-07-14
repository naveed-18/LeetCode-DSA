class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return tabulationSpaceOptimized(nums, n);
    }
    public int tabulationSpaceOptimized (int[] nums, int n) {
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prevIdx = i - 1; prevIdx >= -1; prevIdx--) {
                int pick = 0;
                if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
                    pick = 1 + next[i + 1];
                } 
                int notPick = 0 + next[prevIdx + 1];
                curr[prevIdx + 1] = Math.max(pick, notPick);
            }
            next = curr;
        }

        return next[0];        
    }
}