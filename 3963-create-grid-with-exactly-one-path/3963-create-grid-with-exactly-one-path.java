class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        StringBuilder sb = new StringBuilder();

        // FIRST ROW
        sb.repeat('.', n);
        result[0] = sb.toString();

        // REMAINING ROWS
        sb = new StringBuilder();
        sb.repeat('#', n - 1);
        sb.append('.');

        for (int i = 1; i < m; i++) {
            result[i] = sb.toString();
        }

        return result;
    }
}