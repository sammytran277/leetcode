// https://leetcode.com/problems/palindrome-number/

public class PalindromeNumber {
    public boolean isPalindrome(int n) {        
        if (n < 0 || (n % 10 == 0 && n != 0)) {
            return false;
        }
        
        int reversed = 0;
        while (n > reversed) {
            reversed *= 10;
            reversed += n % 10;
            n /= 10;
        }
        
        return n == reversed || n == reversed / 10;
    }
}