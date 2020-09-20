// https://leetcode.com/problems/first-missing-positive/

public class FindMissingPositive {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] > 0 && A[i] <= A.length - 1 && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        
        return A.length + 1;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}