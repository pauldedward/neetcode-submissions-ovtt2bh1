class Solution {
    int ROWS;
    int COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        boolean[][] safe = new boolean[ROWS][COLS];

        for(int x = 0; x < ROWS; x++) {
            dfs(board, x, 0, safe);
            dfs(board, x, COLS - 1, safe);
        }

        for(int y = 0; y < COLS; y++) {
            dfs(board, 0, y, safe);
            dfs(board, ROWS - 1, y, safe);
        }

        for(int x = 0; x < ROWS; x++) {
            for(int y = 0; y < COLS; y++) {
                if(board[x][y] == 'O' && !safe[x][y]) {
                    board[x][y] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y, boolean[][] safe) {
        if(x < 0 || x >= ROWS || y < 0 || y >= COLS || safe[x][y] || board[x][y] == 'X') {
            return;
        }

        safe[x][y] = true;
        dfs(board, x + 1, y, safe);
        dfs(board, x - 1, y, safe);
        dfs(board, x, y + 1, safe);
        dfs(board, x, y - 1, safe);
    }
}
