class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n == 2 || n == 3) return new ArrayList<List<String>>();

        List<List<String>> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(Arrays.asList("Q"));
            return ans;
        }

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1]; 
        int[] upperDiagonal = new int[2 * n - 1]; 

        solve(0, board, n, leftRow, lowerDiagonal, upperDiagonal, ans);
        
        return ans;
    }

    public void solve(int col, char[][] board, int n, 
        int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, 
        List<List<String>> ans) {

        if(col == n) {
            ans.add(construct(board, n));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && 
                lowerDiagonal[row + col] == 0 && 
                upperDiagonal[n - 1 + col - row] == 0) {

                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, board, n, leftRow, lowerDiagonal, upperDiagonal, ans);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    public List<String> construct(char[][] board, int n) {
        List<String> comb = new ArrayList<>();
        for(int i = 0; i < n; i++) comb.add(new String(board[i]));
        return comb;
    }
}