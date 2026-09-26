class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{ -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }};

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int[] dir : directions) {
                int r = node[0] + dir[0];
                int c = node[1] + dir[1];
                if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 2147483647) {
                    continue;
                }
                queue.add(new int[] {r, c});
                grid[r][c] = grid[node[0]][node[1]] + 1;
            }
        }
    }
}
