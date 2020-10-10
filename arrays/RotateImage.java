// https://leetcode.com/problems/rotate-image/

public class RotateImage {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        reverse(matrix, N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public void reverse(int[][] A, int N) {
        int i = 0;
        int j = N - 1;
        while (i < j) {
            int[] temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}