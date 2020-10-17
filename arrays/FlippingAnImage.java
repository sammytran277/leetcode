// https://leetcode.com/problems/flipping-an-image/

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int numRows = A.length;
        int numCols = A[0].length;
        for (int i = 0; i < numRows; i++) {
            int start = 0;
            int end = numCols - 1;
            while (start <= end) {
                int temp = A[i][start];
                A[i][start] = (A[i][end] == 1) ? 0 : 1;
                A[i][end] = (temp == 1) ? 0 : 1;
                start++;
                end--;
            }
        }
        
        return A;
    }
}
