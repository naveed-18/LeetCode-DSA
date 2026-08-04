class Solution {
    public int maxDistance(String moves) {
        int countU = 0, countD = 0, countR = 0, countL = 0;
        int countSpace = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') countU++;
            else if (c == 'D') countD++;
            else if (c == 'R') countR++;
            else if (c == 'L') countL++;
            else countSpace++;
        }

        int netDist1 = Math.abs(countU - countD);
        int netDist2 = Math.abs(countR - countL);

        return netDist1 + netDist2 + countSpace;
    }
}