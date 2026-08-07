class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxWater = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            maxWater = Math.max(maxWater, (j - i) * h);

            if (height[i] < height[j]) i++;
            else j--;
        }

        return maxWater;
    }
}