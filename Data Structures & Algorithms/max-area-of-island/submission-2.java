class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                maxArea = Math.max(maxArea, findArea(grid, visited, x, y));
            }
        }
        return maxArea;
    }

    public int findArea(int[][] grid, boolean[][] visited,  int x, int y) {
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == 0 || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int area = 1;
        area += findArea(grid, visited, x + 1, y);
        area += findArea(grid, visited, x - 1, y);
        area += findArea(grid, visited, x, y + 1);
        area += findArea(grid, visited, x, y - 1);
        return area;
    }
}
