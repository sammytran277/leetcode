// https://leetcode.com/problems/squares-of-a-sorted-array/

import java.util.Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            A[i] *= A[i];
        }
        
        Arrays.sort(A);
        return A;
    }
}