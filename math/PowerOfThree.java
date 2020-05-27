// https://leetcode.com/problems/power-of-three/

public class PowerOfThree 
{
    public boolean isPowerOfThree(int n) 
    {
        int i = 0;
        while (Math.pow(3, i) <= n) 
        {
            if (Math.pow(3, i) == n)
                return true;
            else
                i++;
        }
        
        return false;
    }
}