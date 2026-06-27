class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0) return n;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int len = 1;
                int curr = num;
                while (set.contains(curr + 1)) {
                    len++;
                    curr++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}