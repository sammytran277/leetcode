// https://leetcode.com/problems/partition-equal-subset-sum/

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if ((sum % 2 != 0)) {
            return false;
        }
        
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                int left = j - nums[i - 1];
                if (left >= 0) {
                    dp[i][j] |= dp[i - 1][left];
                }
            }
        }
        
        return dp[n][target];
    }    
}
