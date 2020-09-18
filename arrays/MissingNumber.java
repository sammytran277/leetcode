// https://leetcode.com/problems/missing-number/

public class MissingNumber {
    public int missingNumber(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != A.length && A[i] != i) {
                swap(A, i, A[i]);
            } else {
                i++;
            }
        }
        
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j) {
                return j;
            }
        }
        
        return A.length;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}