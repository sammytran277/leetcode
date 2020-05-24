// https://leetcode.com/problems/interval-list-intersections/

import java.util.ArrayList;

public class IntervalListIntersections 
{
    public int[][] intervalIntersection(int[][] A, int[][] B) 
    {
        ArrayList<int[]> intersections = new ArrayList<int[]>();
        int aPointer = 0, bPointer = 0, m = A.length, n = B.length;
        
        // Key idea: Two pointers, move the one with the smaller right bound
        while (aPointer < m && bPointer < n) {
            getIntersection(A[aPointer], B[bPointer], intersections);
            if (A[aPointer][1] > B[bPointer][1]) {
                bPointer++;
            } else {
                aPointer++;
            }
        }
        
        // Convert ArrayList<int[]> to int[][]
        int[][] result = new int[intersections.size()][];
        for (int i = 0; i < intersections.size(); i++) {
            result[i] = intersections.get(i);
        }
        
        return result;
    }
    
    // Given two closed intervals, push the intersection to an array
    public void getIntersection(int[] A, int[] B, ArrayList<int[]> intersections) 
    {
        if (A[0] >= B[0] && A[0] <= B[1]) 
        {
            if (A[1] >= B[0] && A[1] <= B[1]) 
            {
                // Take the entirety of A
                intersections.add(A);
            } 
            else 
            {
                // Take the start of A to end of B
                int[] intersection = new int[]{A[0], B[1]};
                intersections.add(intersection);
            }
        } 
        else 
        {
            if (A[1] >= B[0] && A[1] <= B[1]) 
            {
                // Take start of B to end of A
                int[] intersection = new int[]{B[0], A[1]};
                intersections.add(intersection);
            } 
            else 
            {
                if (A[0] < B[0] && A[1] > B[1]) 
                {
                    // Take the entirety of B
                    intersections.add(B);
                } 
                else 
                {
                    // No intersection at all
                    return;
                }
            }
        }
    }
}