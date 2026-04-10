class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 3) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int current = 0; current < n; current++) {
            if (current > 0 && nums[current] == nums[current - 1]) continue;
            findTriplets (current, current + 1, n - 1, nums, n, result);
        }

        return result;
    }

    public void findTriplets (int current, int low, int high, int[] nums, int n, List<List<Integer>> result) {
        while (low < high) {
            int currSum = nums[current] + nums[low] + nums[high];

            if (currSum == 0) {
                result.add(List.of(nums[current], nums[low], nums[high]));
                low++;
                high--;
            } else if (currSum < 0) {
                low++;
            } else {
                high--;
            }

            while (low < high && low > current + 1 && nums[low] == nums[low - 1]) low++;
            while (low < high && high < n - 1 && nums[high] == nums[high + 1]) high--;

        }
    }
}