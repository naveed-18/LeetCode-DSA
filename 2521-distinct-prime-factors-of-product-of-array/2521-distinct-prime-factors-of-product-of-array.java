class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int count = 0;

            while (num % 2 == 0) {
                count++;
                num /= 2;
            }
            if (count > 0) set.add(2);

            for (int i = 3; i * i <= num; i += 2) {
                count = 0;
                while (num % i == 0) {
                    count++;
                    num /= i;
                }
                if (count > 0) set.add(i);
            }

            if (num > 1) set.add(num);
        }

        return set.size();
    }
}