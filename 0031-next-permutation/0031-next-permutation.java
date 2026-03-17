class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            reverse (0, n - 1, nums);
            return;
        }

        for (int i = n - 1; i >= breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                swapNumber (i, breakPoint, nums);
                break;
            }
        }

        reverse (breakPoint + 1, n - 1, nums);
    }

    public void reverse (int start, int end, int[] nums) {
        while (start < end) {
            swapNumber (start, end, nums);
            start++;
            end--;
        }
    }

    public void swapNumber (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}