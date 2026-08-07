class Solution {
    public boolean isSubsequence(String s, String t) {
        return isSubseq(0, 0, s, t);
    }

    public boolean isSubseq (int idx1, int idx2, String s, String t) {
        if (idx1 == s.length()) return true;
        if (idx2 == t.length()) return idx1 == s.length();

        if (s.charAt(idx1) == t.charAt(idx2)) {
            return isSubseq(idx1 + 1, idx2 + 1, s, t);
        }

        return isSubseq(idx1, idx2 + 1, s, t);
    }

    public boolean isSubsequenceTwoPointer(String s, String t) {
        int idx1 = 0, idx2 = 0;

        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1) == t.charAt(idx2)) {
                idx1++;
                idx2++;
            } else {
                idx2++;
            }
        }

        return idx1 == s.length();
    }
}