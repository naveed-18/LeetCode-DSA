class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = n - 1;
        int res = 0;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == k) {
                res++;
                low++;
                high--;
            } else if (sum < k) low++;
            else high--;
        }

        return res;
    }
}