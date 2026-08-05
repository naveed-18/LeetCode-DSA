class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            int totalCandies = candy + extraCandies;
            if (totalCandies >= maxCandies) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }
}