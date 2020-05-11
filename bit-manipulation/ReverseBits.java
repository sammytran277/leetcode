// https://leetcode.com/problems/reverse-bits/

public class ReverseBits 
{
    public int reverseBits(int n) 
    {
        int reverse = 0;
        
        for (int i = 0; i < 32; i++) 
        {
            if ((n & (1 << i)) != 0)
                reverse ^= (1 << (31 - i));
        }
        
        return reverse;
    }
}