class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = 1;
        int maxLen = 1;
        int n = nums.length; 

        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) len = 1 ;
            else len++;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}