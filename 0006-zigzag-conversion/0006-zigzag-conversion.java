class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) return s;

        int idx = 0, dir = 1;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        for (char c : s.toCharArray()) {
            rows[idx].append(c);
            if (idx == 0) dir = 1;
            else if (idx == numRows - 1) dir = -1;
            idx += dir;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}