// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (getNumberOfDigits(num) % 2 == 0) {
                ans++;
            }
        }
        
        return ans;
    }
    
    public int getNumberOfDigits(int n) {
        if (n == 0) {
            return 1;
        }
        
        int digits = 0;
        while (n != 0) {
            n /= 10;
            digits++;
        }
        
        return digits;
    }
}