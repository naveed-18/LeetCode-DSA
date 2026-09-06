class Solution {
    public char findTheDifference(String s, String t) {
        int sSum = 0;
        for (char c : s.toCharArray()) {
            sSum += c;
        }
        int tSum = 0;
        for (char c : t.toCharArray()) {
            tSum += c;
        }
        return (char)(tSum - sSum);
    }
}