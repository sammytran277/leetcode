// https://leetcode.com/problems/unique-paths/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Set top edge to 1
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        
        // Set left edge to 1
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;
        
        // For (m, n), the number of ways to get there is (m - 1, n) + (m, n - 1)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
        
        return dp[m - 1][n - 1];
    }
}