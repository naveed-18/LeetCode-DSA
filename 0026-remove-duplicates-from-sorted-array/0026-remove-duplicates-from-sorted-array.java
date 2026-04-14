class Solution {
    public int removeDuplicates(int[] nums) {
        // TWO POINTERS
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        return i + 1;
    }
}