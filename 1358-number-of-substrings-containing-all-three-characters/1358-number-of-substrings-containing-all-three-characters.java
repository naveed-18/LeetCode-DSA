class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastIndex = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;

            count += (1 + Math.min(lastIndex[0], Math.min(lastIndex[1], lastIndex[2])));
        }

        return count;
    }
}