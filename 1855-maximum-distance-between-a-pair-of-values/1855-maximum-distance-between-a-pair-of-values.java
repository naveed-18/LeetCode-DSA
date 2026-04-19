class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        return maxDistanceOptimal (nums1, nums2);
    }

    public int maxDistanceOptimal (int[] nums1, int[] nums2) {
        int maxDis = Integer.MIN_VALUE;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                maxDis = Math.max(maxDis, j - i);
                j++;
            } else {
                i++;
                if (i > j) j = i;
            }

        }
        return maxDis == Integer.MIN_VALUE ? 0 : maxDis;
    }

    public int maxDistanceBruteForce(int[] nums1, int[] nums2) {
        int maxDis = Integer.MIN_VALUE;
        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int i = 0; i < n1; i++) {
            for (int j = i; j < n2; j++) {
                if (nums1[i] <= nums2[j]) {
                    maxDis = Math.max(maxDis, j - i);
                }
            }
        }

        return maxDis == Integer.MIN_VALUE ? 0 : maxDis;
    }
}