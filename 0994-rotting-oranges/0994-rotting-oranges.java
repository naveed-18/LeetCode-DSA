class Solution {
    class Points {
        int i, j;
        Points(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Points> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Points(i, j));
                }
            }
        }

        int minTime = bfs(grid, n, m, q);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return minTime < 0 ? 0 : minTime;
    }

    public int bfs (int[][] grid, int n, int m, Queue<Points> q) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int min = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Points point = q.poll();
                int currI = point.i;
                int currJ = point.j;

                for (int[] dir : directions) {
                    int newI = currI + dir[0];
                    int newJ = currJ + dir[1];

                    if (newI >= 0 && newI < n 
                        && newJ >= 0 && newJ < m 
                        && grid[newI][newJ] != 0 
                        && grid[newI][newJ] != 2) {

                        grid[newI][newJ] = 2;
                        q.offer(new Points(newI, newJ));
                    }
                }
            }
            min++;
        }

        return min;
    }
}