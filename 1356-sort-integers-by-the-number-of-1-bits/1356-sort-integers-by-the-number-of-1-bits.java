class Solution {
    public int[] sortByBits(int[] nums) {
        return sortByBitsApproach2(nums);
    }

    public int[] sortByBitsApproach2(int[] nums) {
        int n = nums.length;
        Integer[] numsSort = new Integer[n];
        for (int i = 0; i < n; i++) numsSort[i] = nums[i];

        Arrays.sort(numsSort, (e1, e2) -> {
            int countE1 = Integer.bitCount(e1);
            int countE2 = Integer.bitCount(e2);

            if (countE1 == countE2) return Integer.compare(e1, e2);
            return Integer.compare(countE1, countE2);
        });

        for (int i = 0; i < n; i++) nums[i] = numsSort[i];

        return nums;
    }

    public int[] sortByBitsApproach1(int[] nums) {
        TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        for (int num : nums) {
            int count = Integer.bitCount(num);
            if (!hm.containsKey(count)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num);
                hm.put(count, list);
            } else {
                hm.get(count).add(num);
            }
        }

        int i = 0;
        for (int num : hm.keySet()) {
            ArrayList<Integer> list = hm.get(num);
            Collections.sort(list);
            for (int l : list) nums[i++] = l; 
        }

        return nums;
    }
}