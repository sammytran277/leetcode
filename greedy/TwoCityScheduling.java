// https://leetcode.com/problems/two-city-scheduling/

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    /* Idea is to sort by the difference in price between cities
       Negative numbers mean price of A < price of B
       Positive numbers mean price of B > price of A */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return (a[0] - a[1]) - (b[0] - b[1]);
           } 
        });
        
        int minCost = 0, n = costs.length;
        for (int i = 0; i < n; i++) {
            if (i < n / 2)
                minCost += costs[i][0];
            else
                minCost += costs[i][1];
        }
        
        return minCost;
    }
}