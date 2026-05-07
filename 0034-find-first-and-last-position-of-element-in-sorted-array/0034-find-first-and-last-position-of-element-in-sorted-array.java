class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int n = nums.length;
        result[0] = getStartIndex (nums, n, target);
        result[1] = getEndIndex (nums, n, target);

        return result;
    }

    public int getStartIndex (int[] nums, int n, int target) {
        int low = 0, high = n - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    public int getEndIndex (int[] nums, int n, int target) {
        int low = 0, high = n - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}