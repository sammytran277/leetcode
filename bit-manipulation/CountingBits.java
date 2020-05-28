// https://leetcode.com/problems/counting-bits/

public class CountingBits 
{
    public int[] countBits(int num) 
    {
        int count;
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) 
        {
            count = 0;
            for (int j = 0; j < 32; j++) 
            {
                if ((i & (1 << j)) != 0)
                    count++;
            }
            
            bits[i] = count;
        }
        
        return bits;
    }
}