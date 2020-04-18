public class MinimumPathSum
{
    public static int minPathSum(int[][] grid) 
    {
        // Check for edge cases
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        /* Idea is to modify the grid so the value at grid[i][j] is the
           minimum cost to get to that particular cell */
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                // Only way to have gotten here is from the left
                if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j - 1];
                // Only way to have gotten here is from above
                else if (i != 0 && j == 0)
                    grid[i][j] += grid[i - 1][j];
                // Take the less expensive way to get to this cell
                else if (i != 0 && j != 0)
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[m - 1][n - 1];
    }
}