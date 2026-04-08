class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int deleteChar = 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (deleteChar == 1) {
                deleteChar = 0;
                return check(s, i, j - 1) || check(s, i + 1, j);
            } 
        }

        return true;
    }

    public boolean check (String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}