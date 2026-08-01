class Solution {
    public boolean predictTheWinner(int[] nums) {
        return predict(0, nums.length - 1, nums, true, 0, 0);
    }

    public boolean predict(int first, int last, int[] nums, boolean turn, int score1, int score2) {
        if (first > last) {
            return score1 >= score2;
        }

        if (turn) {
            return predict(first + 1, last, nums, false, score1 + nums[first], score2) ||
            predict(first, last - 1, nums, false, score1 + nums[last], score2);
        }

        return predict(first + 1, last, nums, true, score1, score2 + nums[first]) &&
        predict(first, last - 1, nums, true, score1, score2 + nums[last]);
    }
}