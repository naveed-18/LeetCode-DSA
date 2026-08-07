class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 1) return 1;

        int currIdx = 0;
        int i = 0;
        while (i < n) {
            char currChar = chars[i];
            int count = 0;

            while (i < n && currChar == chars[i]) {
                count++;
                i++;
            }

            chars[currIdx++] = currChar;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) chars[currIdx++] = c;
            }
        }

        return currIdx;
    }
}