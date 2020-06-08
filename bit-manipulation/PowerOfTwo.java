// https://leetcode.com/problems/power-of-two/

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == Integer.MIN_VALUE)
            return false;
        
        int setBits = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                setBits++;
        }
        
        return setBits == 1;
    }
}