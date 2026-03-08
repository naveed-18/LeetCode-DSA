class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combSum(candidates, 0, candidates.length, target, new ArrayList<>(), ans);
        return ans;
    }
    public void combSum(int[] nums, int idx, int n, int target, List<Integer> curr, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) return;
        for(int i = idx; i < n; i++) {
            if(i > idx && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target) break;
            curr.add(nums[i]);
            combSum(nums, i + 1, n, target - nums[i], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}