class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProd = new int[n];
        int[] rightProd = new int[n];
        int[] result = new int[n];

        leftProd[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftProd[i] = leftProd[i - 1] * nums[i];
        }

        rightProd[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightProd[i] = rightProd[i + 1] * nums[i];
        }

        
        result[0] = rightProd[1];
        result[n - 1] = leftProd[n - 2];
        for (int i = 1; i < n - 1; i++) {
            result[i] = leftProd[i - 1] * rightProd[i + 1];
        }

        return result;
    }
}