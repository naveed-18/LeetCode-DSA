class Solution {
    public int maxProduct(int[] nums) {
        int lpro = 1, rpro = 1;
        int n = nums.length;
        int maxPro = nums[0];

        for(int i = 0; i < n; i++){
            lpro = lpro == 0? 1:lpro;
            rpro = rpro == 0? 1:rpro;

            lpro *= nums[i];
            rpro *= nums[n - 1 - i];

            maxPro = Math.max(maxPro, Math.max(lpro,rpro));
        }
        return maxPro;
    }
}