class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxi = nums[0], mini = nums[0];
        int a = 0, b = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            a = Math.max(nums[i], a + nums[i]);
            maxi = Math.max(maxi, a);
            b = Math.min(nums[i], b + nums[i]);
            mini = Math.min(mini, b);
            sum += nums[i];
        }
        if (maxi < 0){
            return maxi;
        }
        return Math.max(maxi, sum - mini);
    }
}