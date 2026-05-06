class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) sum += k;
            count += hm.getOrDefault(sum, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}