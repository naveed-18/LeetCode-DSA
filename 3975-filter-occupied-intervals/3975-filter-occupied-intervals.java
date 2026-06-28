class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, 
        int freeStart, int freeEnd) {
        
        Arrays.sort(occupiedIntervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : occupiedIntervals) {
            int start = interval[0];
            int end = interval[1];

            if (merged.size() > 0) {
                int[] last = merged.get(merged.size() - 1);
                if (last[1] + 1 >= start) {
                    last[1] = Math.max(last[1], end);
                } else {
                    merged.add(new int[]{start, end});
                }
            } else {
                merged.add(new int[]{start, end});
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] merge : merged) {
            int start = merge[0];
            int end = merge[1];

            if (end < freeStart || start > freeEnd) {
                result.add(Arrays.asList(start, end));
                continue;
            }

            if (start < freeStart) {
                result.add(Arrays.asList(start, freeStart - 1));
            }

            if (end > freeEnd) {
                result.add(Arrays.asList(freeEnd + 1, end));
            }
        }

        return result;
    }
}