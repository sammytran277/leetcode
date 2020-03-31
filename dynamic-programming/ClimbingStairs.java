// https://leetcode.com/problems/climbing-stairs/

import java.util.ArrayList;

public class ClimbingStairs 
{
    public int climbStairs(int n) 
    {
        ArrayList<Integer> stairs = new ArrayList<Integer>();
        
        stairs.add(0);
        stairs.add(1);
        stairs.add(2);

        for (int i = 3; i < n + 1; i++)
            stairs.add(stairs.get(i - 1) + stairs.get(i - 2));
        
        return stairs.get(n);
    }
}