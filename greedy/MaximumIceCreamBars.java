// https://leetcode.com/problems/maximum-ice-cream-bars/

import java.util.*;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int i = 0; coins > 0 && i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                coins -= costs[i];
                res++;
            }
        }
        
        return res;
    }    
}
