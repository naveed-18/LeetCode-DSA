class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = shifts.length;
        int m = tasks.length;
        int[] result = new int[n];
    
        long[] prefixSum = new long[m];
        prefixSum[0] = tasks[0];
        for (int i = 1; i < m; i++) {
            prefixSum[i] = prefixSum[i - 1] + (1L * tasks[i]);
        }

        long previousTime = 0;
        for (int i = 0; i < n; i++) {
            long time = shifts[i] + previousTime;
            int res = binarySearch(prefixSum, m, time);
            result[i] = m - res - 1;

            if (result[i] > 0) previousTime += shifts[i];
            else previousTime = 0;
        }

        return result;
    }

    public int binarySearch(long[] nums, int n, long target) {
        int low = 0;
        int high = n - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}