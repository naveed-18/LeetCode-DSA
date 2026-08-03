class Solution {
    public int largestInteger(int n, int s) {
        if (s == 0) return 0;
        if (s > 9 * n) return -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Math.min(9, s);
            sb.append(num);
            s -= num;
        }

        return Integer.parseInt(sb.toString());
    }
}