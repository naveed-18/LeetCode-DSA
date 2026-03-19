class Solution {
    public class Location {
        int i, j, sum;
        public Location (int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return dijkstraApproach(grid.length, grid[0].length, grid);
        // return dfsPath(n - 1, m - 1, grid);
        return memoization(n - 1, m - 1, grid, dp);
        // return tabulation(n, m, grid);
        // return tabulationSpaceOptimized(n, m, grid);
    }

    public int dfsPath(int i, int j, int[][] grid) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];

        int up = dfsPath(i - 1, j, grid);
        int left = dfsPath(i, j - 1, grid);

        return grid[i][j] + Math.min(up, left);
    }

    public int memoization (int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];

        if (dp[i][j] != -1) return dp[i][j];

        int up = memoization(i - 1, j, grid, dp);
        int left = memoization(i, j - 1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }

    public int tabulation (int n, int m, int[][] grid) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = grid[i][j] + Math.min(up, left);  
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public int tabulationSpaceOptimized(int n, int m, int[][] grid) {
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) temp[j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (i > 0) up = dp[j];
                    if (j > 0) left = temp[j - 1];
                    temp[j] = grid[i][j] + Math.min(up, left);  
                }
            }
            dp = temp;
        }
        return dp[m - 1];
    }

    public int dijkstraApproach(int n, int m, int[][] grid) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        int[][] directions = {{1, 0}, {0, 1}};
        PriorityQueue<Location> q = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e1.sum, e2.sum);
        });

        q.offer(new Location(0, 0, grid[0][0]));
        dp[0][0] = grid[0][0];

        while (!q.isEmpty()) {
            Location current = q.poll();
            int currI = current.i;
            int currJ = current.j;
            int currSum = current.sum;

            for (int[] dir : directions) {
                int newI = currI + dir[0];
                int newJ = currJ + dir[1];

                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && dp[newI][newJ] > currSum + grid[newI][newJ]) {
                    q.offer(new Location(newI, newJ, currSum + grid[newI][newJ]));
                    dp[newI][newJ] = currSum + grid[newI][newJ];
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}