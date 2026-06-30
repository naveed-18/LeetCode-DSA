class Solution {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        int maxFreq = 1;
        int maxEle = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0 && maxFreq <= hm.get(nums[i])) {
                maxFreq = hm.get(nums[i]);
                maxEle = nums[i];
            }
        }

        return maxEle;
    }
}