class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                Character value = board[row][col];
                if(value == '.') {
                    continue;
                }
                String squareKey = (row / 3) + "." + (col / 3);
                if(rows.computeIfAbsent(row, k -> new HashSet<>()).contains(value)
                    || columns.computeIfAbsent(col, k -> new HashSet<>()).contains(value)
                    || squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(value)) {
                        return false;
                }

                rows.get(row).add(value);
                columns.get(col).add(value);
                squares.get(squareKey).add(value);
            }
        }
        return true;
    }
}
