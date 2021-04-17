// https://leetcode.com/problems/target-sum/

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (target < -sum || target > sum) {
            return 0;
        }
        
        int n = nums.length;
        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                int plus = j + nums[i - 1];
                if (plus < 2 * sum + 1) {
                    dp[i][j] += dp[i - 1][plus];
                }
                
                int minus = j - nums[i - 1];
                if (minus >= 0) {
                    dp[i][j] += dp[i - 1][minus];
                }
            }
        }

        return dp[n][target + sum];
    }    
}
