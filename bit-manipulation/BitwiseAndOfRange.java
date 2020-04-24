// https://leetcode.com/problems/bitwise-and-of-numbers-range/

public class BitwiseAndOfRange
{
    public int rangeBitwiseAnd(int m, int n) 
    {
        int count = 0;
        while (m != n)
        {
            m >>= 1;
            n >>= 1;
            count++;
        }
        
        return m << count;
    }
}