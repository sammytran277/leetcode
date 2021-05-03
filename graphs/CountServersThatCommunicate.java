// https://leetcode.com/problems/count-servers-that-communicate/

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] serversInRow = new int[m];
        int[] serversInCol = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    serversInRow[i]++;
                    serversInCol[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (serversInRow[i] > 1 || serversInCol[j] > 1)) {
                    res++;
                }
            }
        }
        
        return res;
    }
}
