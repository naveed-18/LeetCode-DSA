class Solution {
    public int longestOnes(int[] nums, int k) {
        int countZeros = 0;
        int maxOnes = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (nums[right] == 0) countZeros++;
            while (countZeros > k) {
                if (nums[left] == 0) countZeros--;
                left++;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
            right++;
        }     

        return maxOnes;
    }
}