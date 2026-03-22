class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        return findRotationFourTimes (mat, target, 0);
    }

    public boolean findRotationFourTimes(int[][] mat, int[][] target, int k) {
        if (k == 4) return false;
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int[] row : mat) reverse(row);

        if (check(mat, target)) return true;
        return findRotationFourTimes(mat, target, k + 1);
    }    

    public void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public boolean check (int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        } 

        return true;
    }
}