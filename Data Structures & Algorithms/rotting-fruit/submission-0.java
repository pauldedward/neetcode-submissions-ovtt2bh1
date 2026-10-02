class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int x = 0; x < ROWS; x++) {
            for(int y = 0; y < COLS; y++) {
                if(grid[x][y] == 2) {
                    queue.offer(new int[] {x, y});
                } else if(grid[x][y] == 1) {
                    fresh++;
                }
            }
        }

        int daysGoneBy = 0;
        int[][] directions = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        while(!queue.isEmpty() && fresh > 0) {
            int rottenSizeNow = queue.size();
            while(rottenSizeNow > 0) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    if(nx >= 0 && ny >= 0 && nx < ROWS && ny < COLS && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        queue.offer(new int[] {nx, ny});
                    }
                }
                rottenSizeNow--;
            }
            daysGoneBy++;
        }

        return fresh == 0 ? daysGoneBy : -1;
    }
}
