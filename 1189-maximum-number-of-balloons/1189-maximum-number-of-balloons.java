class Solution {
    public int maxNumberOfBalloons(String text) {
        int countB = 0, countA = 0, countL = 0, countO = 0, countN = 0;

        for (char c : text.toCharArray()) {
            if (c == 'b') countB++;
            else if (c == 'a') countA++;
            else if (c == 'l') countL++;
            else if (c == 'o') countO++;
            else if (c == 'n') countN++;
        }

        int minCount = Integer.MAX_VALUE;
        minCount = Math.min(countB, 
                    Math.min(countA, 
                    Math.min(countL / 2, 
                     Math.min(countO / 2, countN)
                )
            )
        );

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}