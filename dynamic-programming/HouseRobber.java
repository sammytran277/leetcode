// https://leetcode.com/problems/house-robber/

public class HouseRobber 
{
    public int rob(int[] nums) 
    {
        int twoHousesAgo = 0, prevHouse = 0, currHouse;
        for (int i = 0; i < nums.length; i++)
        {
            /* Idea is similar to MinCostClimbingStairs.java, the max you could've robbed
               when you reach the i'th house is the current house and the max profit 
               from two houses ago, or just the max profit from the previous house */
            currHouse = Math.max(nums[i] + twoHousesAgo, prevHouse);
            twoHousesAgo = prevHouse;
            prevHouse = currHouse;
        }
        
        return Math.max(prevHouse, twoHousesAgo);
    }
}