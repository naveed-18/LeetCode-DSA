class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 1) return new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(nums[0])));
        Arrays.sort(nums);
        permutations(nums, 0, nums.length, ans);
        return ans;
    }
    public void permutations(int[] nums, int idx, int n, List<List<Integer>> ans) {
        if(idx == n) {
            ans.add(convert(nums));
            return;
        }
        Set<Integer> seen = new HashSet<>();
        for(int i = idx; i < n; i++) {
            if (seen.contains(nums[i])) continue;
            seen.add(nums[i]);
            nums[i] = nums[i] + nums[idx] - (nums[idx] = nums[i]);
            permutations(nums, idx + 1, n, ans);
            nums[i] = nums[i] + nums[idx] - (nums[idx] = nums[i]);
        }
    }
    public List<Integer> convert(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        for(int n : nums) curr.add(n);
        return curr;
    }
}