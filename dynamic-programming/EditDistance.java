// https://leetcode.com/problems/edit-distance/

public class EditDistance {
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int cost = (s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost));
            }
        }
        
        return dp[n][m];
    }
}