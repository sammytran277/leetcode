// https://leetcode.com/problems/maximal-square/

public class MaximalSquare
{    
    public int maximalSquare(char[][] matrix) 
    {
        int m = matrix.length;
        
        if (m == 0)
            return 0;
            
        int n = matrix[0].length;
        
        if (n == 0)
            return 0;
        
        int maxLength = 0;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                else if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                if (dp[i][j] > maxLength)
                    maxLength = dp[i][j];
            }
        }
        
        return maxLength * maxLength;
    }
}