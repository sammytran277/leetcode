// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class NumberOfSteps 
{
    public int numberOfSteps (int num) 
    {
        int count = 0;
        while (num > 0) 
        {
            count++;
            if (num % 2 == 0)
                num /= 2;
            else
                num--;
        }
        
        return count;
    }    
}