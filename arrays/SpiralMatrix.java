// https://leetcode.com/problems/spiral-matrix/

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int M = matrix.length;
        ArrayList<Integer> elements = new ArrayList<Integer>();
        if (M == 0)
            return elements;
        else if (M == 1)
        {
            for (int n : matrix[0])
                elements.add(n);
            return elements;
        }
        
        int N = matrix[0].length;
        if (N == 1)
        {
            for (int i = 0; i < M; i++)
                elements.add(matrix[i][0]);
            return elements;
        }   
        
        int i = 0, j = 0, layerBound = 0;
        while (elements.size() < M * N)
        {
            // Go right until index out of bounds
            while (elements.size() < M * N && j < N - layerBound)
                elements.add(matrix[i][j++]);
            i++;
            j--;

            // Go down until index out of bounds
            while (elements.size() < M * N && i < M - layerBound)
                elements.add(matrix[i++][j]);
            i--;
            j--;
            // Go left until index out of bounds
            while (elements.size() < M * N && j >= 0 + layerBound)
                elements.add(matrix[i][j--]);
            i--;
            j++;
            // Go up until index out of bounds
            while (elements.size() < M * N && i >= 1 + layerBound)
                elements.add(matrix[i--][j]);
            i++;
            j++;
            layerBound++;
        }
        
        return elements;
    }
}