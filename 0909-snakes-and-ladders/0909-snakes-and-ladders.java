class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] cells = new int[n * n + 1];
        int index = 1;
        boolean isLeftToRight = true;
        for (int i = n - 1; i >= 0; i--) {
            if (isLeftToRight) {
                for (int j = 0; j < n; j++) cells[index++] = board[i][j];
            } else {
                for (int j = n - 1; j >= 0; j--) cells[index++] = board[i][j];
            }
            isLeftToRight = !isLeftToRight;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n * n + 1];
        queue.offer(1);
        isVisited[1] = true;
        int minMoves = 0;

        while (!queue.isEmpty ()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) return minMoves;
                for (int move = 1; move <= 6 && curr + move <= n * n; move++) {
                    int nextMove = curr + move;
                    if (cells[nextMove] != -1) nextMove = cells[nextMove];
                    if (!isVisited[nextMove]) {
                        isVisited[nextMove] = true;
                        queue.offer(nextMove);
                    }
                }
            }
            minMoves++;
        }

        return -1;
    }
}