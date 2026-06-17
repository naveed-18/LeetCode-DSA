class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isSelfDividingNum(num)) result.add(num);
        }
        return result;
    }

    public boolean isSelfDividingNum(int number) {
        int num = number;
        while (num != 0) {
            int last = num % 10;
            if (last == 0 || number % last != 0) return false;
            num /= 10;
        }
        return true;
    }
}