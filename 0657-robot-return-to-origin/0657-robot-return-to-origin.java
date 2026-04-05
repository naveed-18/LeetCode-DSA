class Solution {
    public boolean judgeCircle(String moves) {
        int countUp = 0, countDown = 0;
        int countRight = 0, countLeft = 0;

        for (char dir : moves.toCharArray()) {
            if (dir == 'U') countUp++;
            else if (dir == 'D') countDown++;
            else if (dir == 'R') countRight++;
            else countLeft++;
        }

        return countUp == countDown && countRight == countLeft;
    }
}