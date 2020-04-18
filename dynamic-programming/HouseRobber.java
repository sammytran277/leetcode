// https://leetcode.com/problems/house-robber/

public class HouseRobber 
{
    public int rob(int[] nums) 
    {
        int twoHousesAgo = 0, prevHouse = 0, currHouse;
        for (int i = 0; i < nums.length; i++)
        {
            currHouse = Math.max(nums[i] + twoHousesAgo, prevHouse);
            twoHousesAgo = prevHouse;
            prevHouse = currHouse;
        }
        
        return Math.max(prevHouse, twoHousesAgo);
    }
}