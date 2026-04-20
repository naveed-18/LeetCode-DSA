class Solution {
    public int maxDistance(int[] colors) {
        int maxDis = 0; 
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (colors[i] != colors[j]) {
                    maxDis = Math.max(maxDis, Math.abs(i - j));
                }
            }
        }
        return maxDis;
    }
}