class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int leftProd = nums[0];
        for (int i = 1; i < n; i++) {
            result[i] = leftProd * result[i];
            leftProd *= nums[i];
        }

        return result;
    }

    //O(N) space
    public int[] productExceptSelfApproach2(int[] nums) {
        int n = nums.length;
        int[] rightProd = new int[n];
        int[] result = new int[n];

        rightProd[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightProd[i] = rightProd[i + 1] * nums[i];
        }

        
        result[0] = rightProd[1];
        int leftProd = nums[0];
        for (int i = 1; i < n; i++) {
            if (i + 1 == n) result[i] = leftProd;
            else result[i] = leftProd * rightProd[i + 1];
            leftProd *= nums[i];
        }

        return result;
    }

    //O(2N) space
    public int[] productExceptSelfApproach1(int[] nums) {
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