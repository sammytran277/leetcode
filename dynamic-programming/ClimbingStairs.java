// https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs 
{
    public int climbStairs(int n) 
    {
        int twoStepsAgo = 1, prevStep = 1, currStep = 0;
        for (int i = 2; i < n + 1; i++)
        {
            currStep = twoStepsAgo + prevStep;
            twoStepsAgo = prevStep;
            prevStep = currStep;
        }
            
        return prevStep;
    }
}