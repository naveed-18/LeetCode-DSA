class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 1) return new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(nums[0])));
        permutations(nums, 0, nums.length, ans);
        return ans;
    }
    public void permutations(int[] nums, int idx, int n, List<List<Integer>> ans) {
        if(idx == n) ans.add(convert(nums));
        for(int i = idx; i < n; i++) {
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