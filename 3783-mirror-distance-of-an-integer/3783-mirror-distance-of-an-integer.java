class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    public int reverse (int num) {
        int rev = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            rev = rev * 10 + lastDigit;
            num = num / 10;
        }

        return rev;
    }
}