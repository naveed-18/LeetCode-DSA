class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minDis = Math.min(minDis, Math.abs(i - start));
            }
        }
        return minDis;
    }
}