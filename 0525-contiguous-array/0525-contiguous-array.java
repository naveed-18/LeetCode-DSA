class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(prefix[i])) {
                maxLen = Math.max(maxLen, i - hm.get(prefix[i]));
            } else {
                hm.put(prefix[i], i);
            }
        }

        return maxLen;
    }
}