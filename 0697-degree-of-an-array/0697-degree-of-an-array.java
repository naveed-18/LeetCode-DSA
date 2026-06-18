class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer[]> hm = new HashMap<>();
        int  n = nums.length;
        int maxiFreq = 1;
        
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], new Integer[]{1, i, i});
            } else {
                Integer[] arr = hm.get(nums[i]);
                arr[0]++;
                maxiFreq = Math.max(maxiFreq, arr[0]);
                arr[2] = i;
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (int key : hm.keySet()) {
            Integer[] arr = hm.get(key);
            if (maxiFreq == arr[0]) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }

        return minLen;
    }
}