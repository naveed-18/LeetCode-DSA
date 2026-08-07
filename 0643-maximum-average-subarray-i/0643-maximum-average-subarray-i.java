class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int n = nums.length;

        for (int i = 0; i < k; i++) sum += nums[i];
        double result = sum / k;

        for (int i = k; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - k];

            result = Math.max(result, sum / k);
        }

        return result;
    }
}