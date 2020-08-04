// https://leetcode.com/problems/power-of-four/

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        
        while (num > 1) {
            if (num % 4 == 0)
                num /= 4;
            else
                return false;
        }
        
        return true;
    }
}