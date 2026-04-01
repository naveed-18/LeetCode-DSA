class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                count++;
                majorityElement = num;
            } else if (majorityElement != num) count--;
            else count++;
        }

        return majorityElement;
    }
}