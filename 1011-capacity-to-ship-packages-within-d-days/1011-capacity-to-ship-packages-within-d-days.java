class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int high = 0, low = weights[0];
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShipPackages(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canShipPackages (int[] weights, int maxDays, int minWeight) {
        int day = 1;
        int currWeight = 0;
        for (int weight : weights) {
            if (currWeight + weight > minWeight) {
                day++;
                currWeight = 0;
            }
            currWeight += weight;
            if (day > maxDays) return false;
        }

        return day <= maxDays;
    }
}