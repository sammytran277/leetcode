// https://leetcode.com/problems/arranging-coins/

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            if (sum == n)
                return mid;
            else if (sum <= n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return high;
    }
}