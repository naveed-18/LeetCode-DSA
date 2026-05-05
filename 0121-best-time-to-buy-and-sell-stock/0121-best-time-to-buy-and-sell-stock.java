class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minCost = prices[0];
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            minCost = Math.min(minCost, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
        }

        return maxProfit;
    }
}