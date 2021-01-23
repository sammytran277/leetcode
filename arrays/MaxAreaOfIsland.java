public class MaxAreaOfIsland {
    private int numRows;
    private int numCols;
    private int area;

    public int maxAreaOfIsland(int[][] grid) {
        numRows = grid.length;
        if (numRows == 0) {
            return 0;
        }
        
        numCols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                area = 0;
                dfs(grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
    
    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= numRows || j >= numCols) {
            return;
        } else if (grid[i][j] != 1) {
            return;
        }
        
        grid[i][j] = 0;
        area++;
        
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }    
}
