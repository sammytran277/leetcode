// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

import java.util.*;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[] minRows = new int[rows];
        Arrays.fill(minRows, Integer.MAX_VALUE);
        int[] maxCols = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                minRows[i] = Math.min(minRows[i], matrix[i][j]);
                maxCols[j] = Math.max(maxCols[j], matrix[i][j]);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == minRows[i] && matrix[i][j] == maxCols[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        
        return res;
    }
}