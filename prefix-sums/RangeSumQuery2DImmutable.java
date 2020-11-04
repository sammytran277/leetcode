// https://leetcode.com/problems/range-sum-query-2d-immutable/

class RangeSumQuery2DImmutable {
    int r;
    int c;
    int[][] prefix;
    int[][] matrix;
    
    public RangeSumQuery2DImmutable(int[][] matrix) {
        this.matrix = matrix;
        r = matrix.length;
        c = (r != 0) ? matrix[0].length : 0;
        prefix = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j == 0) {
                    prefix[i][j] = matrix[i][j];
                    continue;
                }
                
                prefix[i][j] = prefix[i][j - 1] + matrix[i][j]; 
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += prefix[i][col2] - prefix[i][col1] + matrix[i][col1];
        }
        
        return sum;
    }
}