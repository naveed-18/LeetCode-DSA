class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++) hs.add(nums[i]);
        int maxCount = 1;
        for(int i : hs) {
            if(!hs.contains(i - 1)) {
                int count = 1;
                int x = i;
                while(hs.contains(x + 1)) {
                    count++;
                    x += 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}