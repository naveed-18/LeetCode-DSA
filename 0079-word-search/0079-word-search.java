class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) &&
                    searchWord(i, j, 0, n, m, board, word)) return true;
            }
        }

        return false;
    }

    public boolean searchWord (int i, int j, int idx, int n, int m, char[][] board, String word) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '$';
        if (searchWord(i + 1, j, idx + 1, n, m, board, word)) return true;
        if (searchWord(i - 1, j, idx + 1, n, m, board, word)) return true;
        if (searchWord(i, j + 1, idx + 1, n, m, board, word)) return true;
        if (searchWord(i, j - 1, idx + 1, n, m, board, word)) return true;
        board[i][j] = temp;

        return false;
    }
}