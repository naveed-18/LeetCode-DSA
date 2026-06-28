class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);

        long totalSum = 0;
        int idx = nums.length - 1;

        for (int i = 0; i < k; i++) {
            totalSum += Math.max(
                1L * nums[idx],
                1L * nums[idx] * mul
            );
            idx--;
            mul--;
        }

        return totalSum;
    }
}