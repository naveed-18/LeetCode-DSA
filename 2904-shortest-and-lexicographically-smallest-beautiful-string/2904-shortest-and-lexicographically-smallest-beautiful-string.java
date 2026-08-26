class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String result = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int countOne = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') countOne++;
                if (countOne == k) {
                    int len = j - i + 1;
                    if (minLen >= len) {
                        result = checkLexicographical(result, minLen, s.substring(i, j + 1), len);
                        minLen = len;
                    }
                }
            }
        }

        return result;
    }

    public String checkLexicographical (String a, int aLen, String b, int bLen) {
        if (bLen < aLen) return b;

        int i = 0, j = 0;
        while (i < aLen) {
            if (a.charAt(i) != b.charAt(j)) return a.charAt(i) == '0' ? a : b;
            i++;
            j++;
        }

        return a;
    }
}