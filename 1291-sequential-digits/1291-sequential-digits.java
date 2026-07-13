class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] ans = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};

        int lowIdx = -1, highIdx = -1;
        for (int i = 0; i < ans.length; i++) {
            if (low <= ans[i] && lowIdx == -1) {
                lowIdx = i;
            }
            if (high < ans[i]) {
                highIdx = i;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (highIdx == -1) highIdx = ans.length;
        if (lowIdx == -1) return result;

        for (int i = lowIdx; i < highIdx; i++) {
            result.add(ans[i]);
        }

        return result;
    }
}