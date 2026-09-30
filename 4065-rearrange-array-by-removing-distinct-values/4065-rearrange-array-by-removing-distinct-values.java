class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] freq = new int[101];
        int maxFreq = 0;

        for (int num : nums) {
            freq[num]++;
            if (freq[num] > maxFreq) maxFreq = freq[num];
        }

        int idx = 0;
        for (int i = 0; i < maxFreq; i++) {
            for (int value = 1; value <= 100; value++) {
                if (freq[value] > 0) {
                    result[idx++] = value;
                    freq[value]--;
                }
            }
        }

        return result;
    }
}