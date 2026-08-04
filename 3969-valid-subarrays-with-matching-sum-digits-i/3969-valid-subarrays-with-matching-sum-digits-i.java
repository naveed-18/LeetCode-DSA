class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int result = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum % 10 == x) {
                    long num = sum;
                    while (num >= 10) num /= 10;
                    if (num == x) result++;
                } 
            }
        }

        return result;
    }
}