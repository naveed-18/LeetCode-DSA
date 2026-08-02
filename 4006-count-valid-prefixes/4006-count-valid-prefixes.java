class Solution {
    public int countValidPrefixes(String s) {
        int count = 0;
        int zeroCount = 0;
        int oneCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeroCount++;
            else oneCount++;

            if (zeroCount == oneCount + 1 || 
                oneCount == zeroCount + 1 || 
                oneCount == zeroCount) count++;
        }

        return count;
    }
}