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

        return  Math.min(countB, 
                    Math.min(countA, 
                    Math.min(countL / 2, 
                    Math.min(countO / 2, countN)
                )
            )
        );
    }
}