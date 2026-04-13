class Solution {
    public void dfsIsland(char[][] grid, boolean[][] visited, int x, int y) {
        if(x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return;
        }
        if(visited[x][y] || grid[x][y] == '0') {
            return;
        }
        visited[x][y] = true;
        dfsIsland(grid, visited, x + 1, y);
        dfsIsland(grid, visited, x - 1, y);
        dfsIsland(grid, visited, x, y + 1);
        dfsIsland(grid, visited, x, y - 1);
    }
    public int numIslands(char[][] grid) {
        if(grid == null) {
            return 0;
        }
        int totalIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                if(!visited[x][y] && grid[x][y] == '1') {
                    totalIslands++;
                    dfsIsland(grid, visited, x, y);
                }
            }
        }
        return totalIslands;
    }
}
