// https://leetcode.com/problems/coin-change-2/

public class CoinChange2 {

    // This is a variation of the classic unbounded knapsack problem
    public int change(int amount, int[] coins) {
        // Edge cases
        if (coins.length == 0)
            return (amount == 0) ? 1 : 0;
        
        int[][] dp = new int[coins.length][amount + 1];
        
        // You can always make an amount of 0 by choosing no coins
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j > 0) {
                    if (i > 0)
                        dp[i][j] = dp[i - 1][j];
                    if (j >= coins[i])
                        dp[i][j] += dp[i][j - coins[i]]; 
                }
            }
        }
        
        return dp[coins.length - 1][amount];
    }
}