class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n : nums) hm.put(n, hm.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((e1, e2) -> 
            Integer.compare(hm.get(e1), hm.get(e2)));

        for(int n : hm.keySet()) {
            minHeap.add(n);
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        int resIdx = 0;
        while(!minHeap.isEmpty()) result[resIdx++] = minHeap.poll();
        
        return result;
    }
}