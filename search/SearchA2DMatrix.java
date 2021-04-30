// https://leetcode.com/problems/search-a-2d-matrix/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
        }
        
        return false;
    } 
}
