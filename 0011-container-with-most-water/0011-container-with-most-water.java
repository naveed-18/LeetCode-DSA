class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxWaterArea = Integer.MIN_VALUE;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i);
            maxWaterArea = Math.max(maxWaterArea, area);
            while (i < j && height[i] <= minHeight) i++;
            while (i < j && height[j] <= minHeight) j--;
        }
        return maxWaterArea;
    }
}