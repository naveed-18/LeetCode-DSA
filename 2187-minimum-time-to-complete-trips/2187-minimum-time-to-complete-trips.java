class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int maxi = time[0];
        for (int t : time) maxi = Math.max (maxi, t);

        long low = 1L, high = 1L * maxi * totalTrips;
        long minTime = Long.MAX_VALUE;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canCompleteTrips (time, totalTrips, mid)) {
                minTime = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minTime;
    }

    public boolean canCompleteTrips (int[] times, int totalTrips, long minTime) {
        long currTotalTrips = 0;

        for (int time : times) {
            long currTrips = minTime / time;
            currTotalTrips += currTrips;
            if (currTotalTrips >= totalTrips) return true;
        }

        return currTotalTrips >= totalTrips;
    }
}