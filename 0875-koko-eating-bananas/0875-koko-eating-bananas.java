class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = piles[0];
        for (int pile : piles) {
            maxi = Math.max (maxi, pile);
        }

        int low = 1, high = maxi;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canKokoEat (piles, h, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public boolean canKokoEat (int[] piles, int hours, int minBanana) {
        int hoursTaken = 0;

        for (int pile : piles) {
            if (pile % minBanana == 0) hoursTaken += (pile / minBanana);
            else hoursTaken += (pile / minBanana) + 1;
            if (hoursTaken > hours) return false;
        }

        return true;
    }
}