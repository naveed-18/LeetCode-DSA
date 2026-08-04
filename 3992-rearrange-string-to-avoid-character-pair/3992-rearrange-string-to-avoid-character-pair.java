class Solution {
    public String rearrangeString(String s, char x, char y) {
        int freqX = 0;
        int freqY = 0;
        for (char ch : s.toCharArray()) {
            if (ch == x) freqX++;
            if (ch == y) freqY++;
        }

        StringBuilder sb = new StringBuilder();

        sb.repeat(y, freqY);
        sb.repeat(x, freqX);

        for (char ch : s.toCharArray()) {
            if (ch == x || ch == y) continue;
            sb.append(ch);
        }

        return sb.toString();
    }
}