// https://leetcode.com/problems/online-stock-span/

import java.util.ArrayList;

public class StockSpanner 
{

    ArrayList<Integer> prices;
    ArrayList<Integer> maxSpan;
    public StockSpanner() 
    {
        prices = new ArrayList<Integer>();
        maxSpan = new ArrayList<Integer>();
    }
    
    public int next(int price) 
    {
        if (maxSpan.isEmpty() || prices.get(prices.size() - 1) > price) 
        {
            prices.add(price);
            maxSpan.add(1);
            return 1;
        } 
        else 
        {
            int span = 1;
            int i = prices.size() - 1;
            while (i >= 0 && price >= prices.get(i)) 
            {
                span += maxSpan.get(i);
                i -= maxSpan.get(i);
            }
            prices.add(price);
            maxSpan.add(span);
            return span;
        }
    }
}