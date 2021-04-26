// https://leetcode.com/problems/triangle/

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];
        dp[0] = new int[1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                int left = (j - 1 >= 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = (j < dp[i - 1].length) ? dp[i - 1][j] : Integer.MAX_VALUE;
                dp[i][j] += Math.min(left, right) + triangle.get(i).get(j);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }
}
