class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] contains = new boolean[101];

        int mini = nums[0];
        int maxi = nums[0];

        for (int num : nums) {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
            contains[num] = true;
        }

        for (int num = mini; num <= maxi; num++) {
            if (!contains[num]) result.add(num);
        }

        return result;
    }
}