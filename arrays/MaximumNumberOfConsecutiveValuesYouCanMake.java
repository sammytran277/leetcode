// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/

import java.util.*;

public class MaximumNumberOfConsecutiveValuesYouCanMake {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int toMake = 1;
        for (int coin : coins) {
            if (coin > toMake) {
                break;
            }
            
            toMake += coin;
        }
        
        return toMake;
    }
}
