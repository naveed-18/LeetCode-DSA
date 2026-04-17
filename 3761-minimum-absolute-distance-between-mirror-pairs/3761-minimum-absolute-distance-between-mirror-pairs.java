class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        if (n == 1) return -1;

        int minDis = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(nums[i])) {
                minDis = Math.min(minDis, Math.abs(i - hm.get(nums[i])));
            }
            int rev = reverse (nums[i]);
            hm.put(rev, i);
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    public int minMirrorPairDistanceBruteForce(int[] nums) {
        int n = nums.length;
        if (n == 1) return -1;

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int rev = reverse (nums[i]);
            for (int j = i + 1; j < n; j++) {
                if (rev == nums[j]) {
                    minDis = Math.min(minDis, Math.abs(i - j));
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    public int reverse (int num) {
        int rev = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            rev = rev * 10 + lastDigit;
            num = num / 10;
        }

        return rev;
    }
}