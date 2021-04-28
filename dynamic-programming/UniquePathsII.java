// https://leetcode.com/problems/unique-paths-ii/

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] dp = new int[rows][cols];
        dp[0][0] = (grid[0][0] == 0) ? 1 : 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 1) {
                    int topPaths = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                    int leftPaths = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                    dp[i][j] += topPaths + leftPaths; 
                }
            }
        }
        
        return dp[rows - 1][cols - 1];
    }    
}
