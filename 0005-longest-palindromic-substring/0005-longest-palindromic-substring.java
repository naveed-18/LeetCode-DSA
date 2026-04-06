class Solution {
    public String checkPalindrome(String s, int p1, int p2) {
        while(p1 >= 0 && p2 < s.length()) {
            if(s.charAt(p1) == s.charAt(p2)) {
                p1--;
                p2++;
            } else return s.substring(p1 + 1, p2);
        }
        return s.substring(p1 + 1, p2);
    }
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        String longestString = "";
        for(int i = 0; i < s.length(); i++) {
            String oddLen = checkPalindrome(s, i, i);
            if(oddLen.length() > longestString.length()) longestString = oddLen;
            String evenLen = checkPalindrome(s, i, i + 1);
            if(evenLen.length() > longestString.length()) longestString = evenLen;
        }
        return longestString;
    }
}