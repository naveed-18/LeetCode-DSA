class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean valid = true;
            boolean changed = false;

            while (num > 0) {
                int last = num % 10;

                if (last == 3 || last == 4 || last == 7) {
                    valid = false;
                    break;
                } else if (last == 2 || last == 5 || last == 6 || last == 9) {
                    changed = true;
                }

                num /= 10;
            }

            if (valid && changed) count++;

        }
        return count;
    }
}