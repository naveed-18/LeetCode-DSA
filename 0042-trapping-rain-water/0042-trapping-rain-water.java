class Solution {
    public int trap(int[] height) {
        return trapTwoPointers(height);
    }

    public int trapTwoPointers(int[] height) {
        int n = height.length;

        int leftMax = 0,
            rightMax = 0,
            maxWaterTrap = 0;

        int left = 0, 
            right = n - 1; 

        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftMax > height[left]) maxWaterTrap += (leftMax - height[left]);
                else leftMax = height[left];
                left++;
            } else {
                if (rightMax > height[right]) maxWaterTrap += (rightMax - height[right]);
                else rightMax = height[right];
                right--;
            }
        }

        return maxWaterTrap;
    }

    public int trapUsingSingleArray(int[] height) {
        // TC : O(2N), SC : O(N)
        int n = height.length;

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int leftMax = Integer.MIN_VALUE;
        int maxWaterTrap = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            maxWaterTrap += (Math.min(leftMax, rightMax[i]) - height[i]);
        }

        return maxWaterTrap;
    }

    public int trapUsingTwoArrays(int[] height) {
        // TC : O(3N), SC : O(2N)

        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int maxWaterTrap = 0;
        for (int i = 0; i < n; i++) {
            maxWaterTrap += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return maxWaterTrap;
    }
}