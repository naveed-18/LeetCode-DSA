class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[100001];
        int n = nums1.length;
        long k = (long) k1 + k2;
        long sum = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int absDiff = Math.abs(nums1[i] - nums2[i]);
            diff[absDiff]++;
            sum += absDiff;
            maxDiff = Math.max(maxDiff, absDiff);
        }

        if (sum <= k) return 0;

        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (diff[i] > 0) {
                long move = Math.min (k, (long)diff[i]);
                diff[i] -= move;
                diff[i - 1] += move;
                k -= move;
            }
        }

        long result = 0;
        for (int i = 0; i <= maxDiff; i++) {
            result += (long) i * i * diff[i];
        }

        return result;
    }
}