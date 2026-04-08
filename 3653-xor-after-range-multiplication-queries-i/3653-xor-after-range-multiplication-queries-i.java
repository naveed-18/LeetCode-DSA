class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = (int)1e9 + 7;
        for (int[] q : queries) {
            int idx = q[0];

            while (idx <= q[1]) {
                long temp = nums[idx];
                nums[idx] = (int)((temp * q[3]) % MOD);
                idx += q[2];
            }
        }

        int ans = 0;
        for (int num : nums) ans ^= num;

        return ans;
    }
}