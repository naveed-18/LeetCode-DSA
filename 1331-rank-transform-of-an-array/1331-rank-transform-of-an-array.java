class Solution {
    public int[] arrayRankTransform(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = nums[i];

        Arrays.sort(result);

        HashMap<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for (int num : result) {
            if (!hm.containsKey(num)) {
                hm.put(num, rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = hm.get(nums[i]);
        }

        return result;
    }
}