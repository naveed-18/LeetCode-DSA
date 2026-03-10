class Solution {
    public int totalNQueens(int n) {
        if(n == 2 || n == 3) return 0;
        if (n == 1) return 1;

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1]; 
        int[] upperDiagonal = new int[2 * n - 1]; 

        return solve(0, board, n, leftRow, lowerDiagonal, upperDiagonal);
    }

    public int solve(int col, char[][] board, int n, 
        int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {

        if(col == n) return 1;

        int count = 0;
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && 
                lowerDiagonal[row + col] == 0 && 
                upperDiagonal[n - 1 + col - row] == 0) {

                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                count += solve(col + 1, board, n, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }

        return count;
    }
}