class Solution {
    public int maximumBeauty(int[] nums, int k) {
        return maximumBeautyMethod2 (nums, k);
    }

    public int maximumBeautyMethod2(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j = 0;
        while (j < n) {
            if (nums[j] - nums[i] > 2 * k) i++;
            j++;
        }

        return j - i;
    }

    public int maximumBeautyMethod1(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += k;
        }

        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max (maxi, num + k);
        }
        
        int[] count = new int[maxi + 2];
        for (int num : nums) {
            count[num - k]++;
            count[num + k + 1]--;
        }

        int[] prefix = new int[maxi + 2];
        prefix[0] = count[0];
        int result = 0;
        for (int i = 1; i < count.length; i++) {
            prefix[i] = prefix[i - 1] + count[i];
            result = Math.max(result, prefix[i]);
        }
        
        return result;
    }
}