class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combSum(candidates.length - 1, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public void combSum (int idx, int[] candidates, int target, 
        List<Integer> currList, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }
        if (idx < 0) return;

        combSum (idx - 1, candidates, target, currList, result);

        if (candidates[idx] <= target) {
            currList.add(candidates[idx]);
            combSum (idx, candidates, target - candidates[idx], currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}