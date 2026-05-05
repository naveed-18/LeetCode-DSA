class Solution {
    public int minSteps(int n) {
        int result = 0;
        while (n % 2 == 0) {
            n /= 2;
            result += 2;
        }

        for (int i = 3; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                result += i;
            }
        }

        if (n > 1) result += n;

        return result;
    }
}