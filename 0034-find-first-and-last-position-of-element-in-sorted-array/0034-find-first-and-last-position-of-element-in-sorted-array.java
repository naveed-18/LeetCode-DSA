class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int n = nums.length;

        result[0] = findFirstPosition (nums, n, target);

        result[1] = findLastPosition (nums, n, target);

        return result;
    }

    public int findFirstPosition (int[] nums, int n, int target) {
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int findLastPosition (int[] nums, int n, int target) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}