// https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/

import java.util.*;

public class GetBiggestThreeRhombusSumsInAGrid {
    private int m;
    private int n;
    
    public int[] getBiggestThree(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n / 2; k++) {
                    int res = rhombusSum(grid, k, i, j);
                    if (res != -1) {
                        set.add(res);
                    }
                }
            }
        }

        return set.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(v -> v).toArray();
    }
    
    
    public int rhombusSum(int[][] grid, int size, int r, int c) {
        if (size == 0) {
            return grid[r][c];
        } else if (c - size < 0 || c + size >= n || r + 2 * size >= m) {
            return -1;
        }
        
        int sum = 0;
        for (int i = 0; i <= size; i++) {
            if (i == 0) {
                sum += grid[r][c];
            } else {
                sum += grid[r + i][c - i] + grid[r + i][c + i];
            }
        }
        
        r += 2 * size;
        for (int i = 0; i <= size - 1; i++) {
            if (i == 0) {
                sum += grid[r][c];
            } else {
                sum += grid[r - i][c - i] + grid[r - i][c + i];
            }
        }
        
        return sum;
    }
}