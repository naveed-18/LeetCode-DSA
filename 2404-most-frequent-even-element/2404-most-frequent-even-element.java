class Solution {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm =new HashMap<>();

        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 1) continue;
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        int maxFreq = 0,maxEle = -1;
        for (int key : hm.keySet()) {
            int val = key, freq = hm.get(key);
            if (maxFreq < freq || (freq == maxFreq && val < maxEle)) {
                maxEle = val;
                maxFreq = freq;
            }
        }

        return maxEle;
    }
}