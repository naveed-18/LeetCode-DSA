class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String row = Arrays.toString(grid[i]);
            hm.put(row, hm.getOrDefault(row, 0) + 1);
        }

        int pairs = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = grid[i][j];
            }
            String col = Arrays.toString(column);
            if (hm.containsKey(col)) pairs += hm.get(col);
        }

        return pairs;
    }
}