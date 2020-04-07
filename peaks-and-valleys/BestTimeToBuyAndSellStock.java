// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyAndSellStock 
{
    /* Example of the peaks and valleys technique, where we visualize
       numbers in a graph and observe the local minima and maxima */ 
    public int maxProfit(int[] prices) 
    {
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        /* Max profit is achieved when we buy at the lowest valley 
           and sell at the highest peak */
        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i] < lowestPrice)
                lowestPrice = prices[i];
            else if (prices[i] - lowestPrice > maxProfit)
                maxProfit = prices[i] - lowestPrice;
        }
        
        return maxProfit;
    }
}