class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getSubset(0, nums, nums.length, new ArrayList<>(), result);
        return result;
    }

    public void getSubset(int idx, int[] nums, int n, 
        List<Integer> currList, List<List<Integer>> result) {

        result.add(new ArrayList<>(currList));
        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            currList.add(nums[i]);
            getSubset(i + 1, nums, n, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}