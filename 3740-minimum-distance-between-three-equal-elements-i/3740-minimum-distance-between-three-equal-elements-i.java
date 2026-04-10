class Solution {
    public int minimumDistance(int[] nums) {
        int minDis = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] != nums[j]) continue;
                int dis1 = Math.abs(i - j);
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] != nums[k]) continue;
                    
                    int dis2 = Math.abs(j - k);
                    int dis3 = Math.abs(k - i);

                    int totalDis = dis1 + dis2 + dis3;
                    minDis = Math.min(minDis, totalDis);
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}