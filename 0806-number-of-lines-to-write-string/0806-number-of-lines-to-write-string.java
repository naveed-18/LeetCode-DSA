class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int currPixels = 0;
        int line = 1;
        for (char c : s.toCharArray()) {
            int pixels = widths[c - 'a'];
            if (currPixels + pixels <= 100) {
                currPixels += pixels;
            } else {
                line++;
                currPixels = pixels;
            }
        }
        return new int[]{line, currPixels};
    }
}