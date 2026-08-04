class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int small = nums[0];
        int large = nums[0];

        for (int num : nums) {
            hs.add(num);
            small = Math.min(small, num);
            large = Math.max(large, num);
        }

        for (int num = small; num <= large; num++) {
            if (!hs.contains(num)) result.add(num);
        }

        return result;
    }
}