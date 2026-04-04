class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int encodedTextLen = encodedText.length();
        int col = encodedTextLen / rows;

        StringBuilder sb = new StringBuilder();

        int startIdx = 0;
        int count = col;
        while (count-- > 0) {
            for (int i = startIdx; i < encodedTextLen; i += col + 1) {
                sb.append(encodedText.charAt(i));
            }
            startIdx++;
        }
        return sb.toString().stripTrailing();
    }
}