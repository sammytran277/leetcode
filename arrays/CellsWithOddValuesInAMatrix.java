// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

public class CellsWithOddValuesInAMatrix {
    private int[][] grid;
    
    public int oddCells(int n, int m, int[][] indices) {
        grid = new int[n][m];
        for (int[] cell : indices) {
            incrementRow(m, cell[0]);
            incrementCol(n, cell[1]);
        }
        
        int res = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell % 2 != 0) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    public void incrementRow(int m, int r) {
        for (int i = 0; i < m; i++) {
            grid[r][i]++;
        }
    }
    
    public void incrementCol(int n, int c) {
        for (int i = 0; i < n; i++) {
            grid[i][c]++;
        }
    }    
}
