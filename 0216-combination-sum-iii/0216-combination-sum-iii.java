class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combSum (1, k, n, new ArrayList<>(), result);
        return result;
    }

    public void combSum (int num, int k, int n, 
        List<Integer> currList, List<List<Integer>> result) {

        if (currList.size() == k) {
            if (n == 0) result.add(new ArrayList<>(currList));
            return;
        }    

        for (int i = num; i <= 9; i++) {
            if (i <= n) {
                currList.add(i);
                combSum (i + 1, k, n - i, currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }
}