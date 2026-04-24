class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countSpace = 0;
        int countR = 0;
        int countL = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'R') countR++;
            else if (c == 'L') countL++;
            else countSpace++;
        }

        return Math.abs(countL - countR) + countSpace;

    }
}