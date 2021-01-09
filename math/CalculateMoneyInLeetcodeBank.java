// https://leetcode.com/problems/calculate-money-in-leetcode-bank/

public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int prevMonday = 0;
        int prevDay = 0;
        int currDayOfWeek = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (currDayOfWeek == 0) {
                prevMonday++;
                total += prevMonday;
                prevDay = prevMonday;
                
            } else {
                prevDay++;
                total += prevDay;
            }

            currDayOfWeek = (currDayOfWeek + 1) % 7;
        }
        
        return total;
    }
}