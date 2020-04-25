// https://leetcode.com/problems/jump-game/

public class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int n = nums.length;
        int target = n - 1;
        
        // Edge cases
        if (n == 0)
            return false;
        else if (n == 1)
            return true;
        
        // Idea is iterate from right to left, storing if, at index i, you can get to the last index
        boolean[] dp = new boolean[n];
        for (int i = target - 1; i >= 0; i--) 
        {
            if (nums[i] == 0)
                dp[i] = false;
            else if (i + nums[i] >= target)
                dp[i] = true;
            for (int j = i; j <= i + nums[i]; j++) {
                if (dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[0];
    }
}