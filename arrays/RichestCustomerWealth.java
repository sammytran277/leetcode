// https://leetcode.com/problems/richest-customer-wealth/

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                wealth += accounts[i][j];
            }
            
            res = Math.max(res, wealth);
        }
        
        return res;
    }
}