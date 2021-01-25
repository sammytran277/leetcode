// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

import java.util.*;

public class FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m][n];
        
        prefix[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            prefix[i][0] = matrix[i][0]^prefix[i-1][0];
        }
        
        for (int j = 1; j < n; j++) {
            prefix[0][j] = matrix[0][j]^prefix[0][j-1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefix[i][j] = matrix[i][j]^prefix[i-1][j-1]^prefix[i-1][j]^prefix[i][j-1];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res.add(prefix[i][j]);
            }   
        }

        Collections.sort(res);
        return res.get(res.size() - k);
    }    
}
