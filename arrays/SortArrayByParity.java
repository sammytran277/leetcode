// https://leetcode.com/problems/sort-array-by-parity/

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (A[i] % 2 != 0) 
                swap(A, i, j--);
            else
                i++; 
        }
        
        return A;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}