class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (nums == null || n < 4) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                int c = b + 1;
                int d = n - 1;

                findQuadruplets (a, b, c, d, nums, n, target, result);
            }
        }

        return result;
    }

    public void findQuadruplets (int a, int b, int c, int d, int[] nums, int n, int target, List<List<Integer>> result) {
        while (c < d) {
            long currSum = nums[a];
            currSum += nums[b];
            currSum += nums[c];
            currSum += nums[d];

            if (currSum == target) {
                result.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                c++;
                d--;
                while (c < d && c > b + 1 && nums[c] == nums[c - 1]) c++;
                while (c < d && d < n - 1 && nums[d] == nums[d + 1]) d--;
            } else if (currSum < target) {
                c++;
            } else {
                d--;
            }
        }
    }
}