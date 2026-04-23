class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        long[] result = new long[n];

        for(List<Integer> list : map.values()) {
            int size = list.size();

            long preSum = 0;
            for(int i=0; i<size; i++) {
                int idx = list.get(i);
                result[idx] += (long)i * idx - preSum;
                preSum += idx;
            }

            long suffSum = 0;
            for(int i=size-1; i>=0; i--) {
                int idx = list.get(i);
                result[idx] += suffSum - (long)(size - 1 - i) * idx;
                suffSum += idx;
            }
        }

        return result;
    }

    public long[] distanceBruteForce(int[] nums) {
        HashMap<Integer, List<Integer>> indices = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!indices.containsKey(nums[i])) indices.put(nums[i], new ArrayList<>());
            indices.get(nums[i]).add(i);
        }

        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            if (indices.containsKey(nums[i])) {
                result[i] = getSum(i, indices.get(nums[i]));
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public long getSum (int currIdx, List<Integer> list) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Math.abs(currIdx - list.get(i)); 
        }
        return sum;
    }
}