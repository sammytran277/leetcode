// Link TBD, 30-Day LeetCoding Challenge Day 21

import java.util.ArrayList;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

public class LeftmostColumnWithOne
{
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) 
    {
        ArrayList<Integer> dimensions = new ArrayList<Integer>(binaryMatrix.dimensions());
        int leftCol = -1, firstOne = -1;
        
        // Conduct binary search on each row of the matrix to find the first 1
        for (int i = 0; i < dimensions.get(0); i++) 
        {
            firstOne = search(binaryMatrix, i, dimensions.get(1));
            if (leftCol == -1)
                leftCol = firstOne;
            else if (leftCol > firstOne && firstOne != -1)
                leftCol = firstOne; 
        }
        
        return leftCol;
    }
    
    public int search(BinaryMatrix binaryMatrix, int rowNum, int numCols) 
    {
        int left = 0, right = numCols - 1, mid;
        int firstOne = Integer.MAX_VALUE, result;
        while (left <= right) 
        {
            mid = left + (right - left) / 2;
            result = binaryMatrix.get(rowNum, mid);
            if (result == 1) 
            {
                firstOne = Math.min(mid, firstOne);
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        
        return (firstOne == Integer.MAX_VALUE) ? -1 : firstOne;
    }
}