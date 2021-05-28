// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

import java.util.*;

public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int n = piles.length;
        int res = 0;
        for (int i = n / 3; i < n; i += 2) {
            res += piles[i];
        }
        
        return res;
    }    
}