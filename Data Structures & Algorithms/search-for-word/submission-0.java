class Solution {
    private int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int column, int index) {
        if(index >= word.length()) {
            return true;
        }
        if(row < 0 || row >= ROWS || column < 0 || column >= COLS
        || board[row][column] != word.charAt(index) || board[row][column] == '#') {
            return false;
        }
        board[row][column] = '#';
        boolean found = dfs(board, word, row + 1, column, index + 1)
            || dfs(board, word, row - 1, column, index + 1)
            || dfs(board, word, row, column + 1, index + 1)
            || dfs(board, word, row, column - 1, index + 1);
        board[row][column] = word.charAt(index);
        return found;
    }
}
