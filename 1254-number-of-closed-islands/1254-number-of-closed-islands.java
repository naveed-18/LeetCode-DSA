class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs (i, 0, grid, m, n);
            dfs (i, n - 1, grid, m, n);
        }

        for (int j = 0; j < n; j++) {
            dfs (0, j, grid, m, n);
            dfs (m - 1, j, grid, m, n);
        }

        int countIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    countIslands++;
                    dfs (i, j, grid, m, n);
                }
            }
        }

        return countIslands;
    }

    public void dfs (int i, int j, int[][] grid, int m, int n) {
        if (!isValid (i, j, m, n) || grid[i][j] == 1) return;

        grid[i][j] = 1;
        dfs (i + 1, j, grid, m, n);
        dfs (i - 1, j, grid, m, n);
        dfs (i, j + 1, grid, m, n);
        dfs (i, j - 1, grid, m, n);
    }

    public boolean isValid (int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}