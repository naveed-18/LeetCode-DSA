class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxOpr = 0;

        for (int num : nums) {
            int need = k - num;
            if (hm.containsKey(need)) {
                maxOpr++;
                if (hm.get(need) == 1) hm.remove(need);
                else hm.put(need, hm.get(need) - 1);
            } else {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
        }

        return maxOpr;
    }

    public int maxOperationsSorting(int[] nums, int k) {
        Arrays.sort(nums);

        int maxOpr = 0;
        int n = nums.length;
        int i = 0, j = n - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                maxOpr++;
                i++;
                j--;
            } else if (sum < k) i++;
            else j--;
        }

        return maxOpr;
    }
}