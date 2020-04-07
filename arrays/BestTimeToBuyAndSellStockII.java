// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class BestTimeToBuyAndSellStockII 
{
    // Another implementation of Kadane's algorithm
    public int maxProfit(int[] prices) 
    {
        if (prices.length == 0)
            return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            profit += Math.max(prices[i] - prices[i - 1], 0);
        return profit;
    }
}