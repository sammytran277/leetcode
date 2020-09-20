// https://leetcode.com/problems/find-the-duplicate-number/

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                return A[j];
            }
        }
        
        return -1;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    } 
}