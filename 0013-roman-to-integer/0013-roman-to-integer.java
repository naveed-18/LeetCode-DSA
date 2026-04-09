class Solution {
    public int romanToInt(String s) {
        int value = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            int currVal = valueOf(s.charAt(i));
            int nextVal = valueOf(s.charAt(i + 1));

            if (currVal < nextVal) value -= currVal;
            else value += currVal;
        }

        return value + valueOf(s.charAt(n - 1));
    }

    public int valueOf(char roman) {
        switch(roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}