class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = mat[i][j];
            }
        }

        k = k % m;

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) leftShiftRows (nums[i], k, m);
            else rightShiftRows (nums[i], k, m);
        }

        return compare (mat, nums, n, m);
    }

    public void leftShiftRows (int[] nums, int k, int n) {
        reverse (nums, 0, n - 1);
        reverse (nums, 0, n - k - 1);
        reverse (nums, n - k, n - 1);
    }

    public void rightShiftRows (int[] nums, int k, int n) {
        reverse (nums, 0, n - 1);
        reverse (nums, 0, k - 1);
        reverse (nums, k, n - 1);
    }

    public void reverse (int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public boolean compare (int[][] mat, int[][] nums, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != nums[i][j]) return false;
            }
        }

        return true;
    }
}