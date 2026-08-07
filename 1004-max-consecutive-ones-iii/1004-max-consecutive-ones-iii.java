class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxOnes = 0;
        int countZero = 0;

        int i = 0, j = 0;
        while (j < n) {
            while (nums[j] == 0 && countZero == k) {
                if (nums[i] == 0) countZero--;
                i++;
            }

            if (nums[j] == 0) countZero++;
            maxOnes = Math.max(maxOnes, j - i + 1);
            j++;
        }

        return maxOnes;
    }
}