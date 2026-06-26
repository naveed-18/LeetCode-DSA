class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += matrix[i][j];
            }
            result[i] = count;
        }

        return result;
    }
}