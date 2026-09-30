class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        int currGroup = 1;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') result[i] = 1 - currGroup;
            else result[i] = currGroup;
            currGroup ^= 1;
        }

        return result;
    }
}