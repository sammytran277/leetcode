// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

public class CountSquareSubmatricesWithAllOnes 
{
    public int countSquares(int[][] A) 
    {
        int m = A.length, n = A[0].length, squares = 0;
        
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (A[i][j] > 0 && i > 0 && j > 0)
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                squares += A[i][j];
            }
        }
        
        return squares;
    }
}