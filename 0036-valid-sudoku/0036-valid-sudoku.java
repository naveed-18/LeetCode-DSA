class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;
                else if(check(i, j, board[i][j], board)) return false;
            }
        }
        return true;
    }
    public boolean check(int row, int col, char ch, char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(col != i && board[row][i] == ch) return true;
            if(row != i && board[i][col] == ch) return true;
            if((3 * (row / 3) + i / 3 != row) && (3 * (col / 3) + i % 3 != col) && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) return true;
        }
        return false;
    }
}