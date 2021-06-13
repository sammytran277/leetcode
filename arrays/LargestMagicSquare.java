// https://leetcode.com/problems/largest-magic-square/

public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        for (int sz = Math.min(numCols, numRows); sz > 1; sz--) {
            for (int i = 0; i <= numRows - sz; i++) {
                for (int j = 0; j <= numCols - sz; j++) {
                    if (isMagicSquare(grid, i, j, sz)) {
                        return sz;
                    }
                }
            }
        }
        
        return 1;
    }
    
    public boolean isMagicSquare(int[][] grid, int r, int c, int sz) {
        int sum = rowSum(grid, r, c, sz);
        for (int i = r + 1; i < r + sz; i++) {
            if (rowSum(grid, i, c, sz) != sum) {
                return false;
            }
        }
        
        for (int i = c; i < c + sz; i++) {
            if (colSum(grid, r, i, sz) != sum) {
                return false;
            }
        }
    
        if (diagSum1(grid, r, c, sz) != sum) {
            return false;
        }
    
        return diagSum2(grid, r, c, sz) == sum;
    }
    
    public int rowSum(int[][] grid, int r, int c, int sz) {
        int sum = 0;
        for (int i = c; i < c + sz; i++) {
            sum += grid[r][i];
        }
        
        return sum;
    }
    
    public int colSum(int[][] grid, int r, int c, int sz) {
        int sum = 0;
        for (int i = r; i < r + sz; i++) {
            sum += grid[i][c];
        }
        
        return sum;
    }
    
    public int diagSum1(int[][] grid, int r, int c, int sz) {
        int sum = 0;
        for (int i = 0; i < sz; i++) {
            sum += grid[r + i][c + i];
        }
        
        return sum;
    }
    
    public int diagSum2(int[][] grid, int r, int c, int sz) {
        int sum = 0;
        for (int i = 0; i < sz; i++) {
            sum += grid[r + sz - 1 - i][c + i];
        }
        
        return sum;
    }
}
