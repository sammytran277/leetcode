// https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int twoStepsAgo = cost[0], prevStep = cost[1], currStep;
        for (int i = 2; i < cost.length; i++)
        {
            /* Cheapest way to get to the i'th step is to 
               take the cheaper of the two previous steps */
            currStep = cost[i] + Math.min(prevStep, twoStepsAgo);
            twoStepsAgo = prevStep;
            prevStep = currStep;
        }
            
        return Math.min(prevStep, twoStepsAgo);
    }
}