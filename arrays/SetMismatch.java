// https://leetcode.com/problems/set-mismatch/

public class SetMismatch {
    public int[] findErrorNums(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        
        int[] ans = new int[2];
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                ans[0] = A[j];
                ans[1] = j + 1;
            }
        }
        
        return ans;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}