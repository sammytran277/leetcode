// https://leetcode.com/problems/coin-change/

public class CoinChange 
{
    // Approach is similar to CombinationSumIV
    public int coinChange(int[] coins, int amount) 
    {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++)
            dp[i] = amount + 1;
        
        for (int i = 1; i < dp.length; i++)
        {
            for (int coin : coins)
            {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}