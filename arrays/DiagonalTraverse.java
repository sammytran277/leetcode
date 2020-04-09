// https://leetcode.com/problems/diagonal-traverse/

public class DiagonalTraverse 
{
    public int[] findDiagonalOrder(int[][] matrix) 
    {
        // Handle edge case where matrix is null
        int M = matrix.length;
        if (M == 0)
            return new int[]{};

        // If M is 1, then the matrix is really a 1D array
        if (M == 1)
            return matrix[0];
        
        int N = matrix[0].length;
        int[] elements = new int[M * N];
        
        // If N is 1, then the matrix is a just an array of length 1 arrays
        if (N == 1)
        {
            for (int i = 0; i < M; i++)
                elements[i] = matrix[i][0];
        }
        
        int i = 0, j = 0, currIndex = 0;
        while (i != M - 1 || j != N - 1)
        {
            // Go in the NE direction until the index is invalid
            while (i >= 0 && j < N)
                elements[currIndex++] = matrix[i--][j++];
            i++;
            j--;
            
            // Figure out whether we should go to the right, down or if we're done
            if (j + 1 < N)
                j++;
            else if (i < M)
                i++;
            else
                return elements;
            
            // Go in the SW direction until the index is invalid
            while (i < M && j >= 0)
                elements[currIndex++] = matrix[i++][j--];
            i--;
            j++;
            
            // Figure out if we need to go down, to the right, or if we're done
            if (i + 1 < M)
                i++;
            else if (j < N)
                j++;
            else
                return elements;
        }
        
        elements[currIndex] = matrix[M - 1][N - 1];
        return elements;
    }
}