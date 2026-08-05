class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int idx1 = 0, idx2 = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        boolean flag = true;
        while (idx1 < n1 && idx2 < n2) {
            if (flag) {
                sb.append(word1.charAt(idx1++));
            } else {
                sb.append(word2.charAt(idx2++));
            }
            flag = !flag;
        }

        if (idx1 < n1) sb.append(word1.substring(idx1, n1));
        if (idx2 < n2) sb.append(word2.substring(idx2, n2));

        return sb.toString();
    }
}