class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = totalSum - x;
        if (target < 0) return -1;
        if (target == 0) return n;

        int i = 0, j = 0, maxSubArrayLen = -1, sum = 0;
        while (j < n) {
            sum += nums[j];
            while (i <= j && sum > target) sum -= nums[i++];
            if (sum == target) maxSubArrayLen = Math.max(maxSubArrayLen, j - i + 1);
            j++;
        }

        return maxSubArrayLen == -1 ? -1 : n - maxSubArrayLen;
    }
}