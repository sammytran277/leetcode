// https://leetcode.com/problems/island-perimeter/

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        
        if (rows == 0)
            return 0;
        
        int cols = grid[0].length;
        
        // Find the first 1 to call DFS on
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    return dfs(grid, i, j, rows, cols);
            }
        }
        
        return 0;
    }
    
    public int dfs(int[][] A, int i, int j, int rows, int cols) {
        // Count number of neighbors that are 0 or out of bounds
        if (i < 0 || j < 0 || i >= rows || j >= cols || A[i][j] == 0)
            return 1;
        else if (A[i][j] == -1)
            return 0;
        
        // Mark current cell as visited
        A[i][j] = -1;
        
        return (
            dfs(A, i + 1, j, rows, cols) 
            + dfs(A, i - 1, j, rows, cols) 
            + dfs(A, i, j + 1, rows, cols) 
            + dfs(A, i, j - 1, rows, cols)
        );
    }
}