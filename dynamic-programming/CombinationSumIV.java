// https://leetcode.com/problems/combination-sum-iv/

public class CombinationSumIV 
{
    public int combinationSum4(int[] nums, int target) 
    {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        /* - i is the current sum that we have at a given moment
           - dp[i] is the number of ways to create i using the numbers in nums 
           - Idea is for each number, n, in nums, figure out how many ways you can
             make (target - n) because that will equal the target value */
        for (int i = 0; i < target + 1; i++)
        {
            for (int n : nums)
            {
                if (i - n >= 0)
                    dp[i] += dp[i - n];
            }
        }
        
        return dp[target];
    }
}