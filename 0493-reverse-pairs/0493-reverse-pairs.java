class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    public int mergeSort(int low, int high, int[] nums) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        int count = mergeSort(low, mid, nums);
        count += mergeSort(mid + 1, high, nums);
        count += countRevPairs(low, mid, high, nums);
        merge(low, mid, high, nums);

        return count;
    }

    public int countRevPairs(int low, int mid, int high, int[] nums) {
        int count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) j++;

            count += (j - (mid + 1));
        }

        return count;
    }

    public void merge(int low, int mid, int high, int[] nums) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        } 

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        for (int idx = low; idx <= high; idx++) {
            nums[idx] = temp[idx - low];
        }
    }
}