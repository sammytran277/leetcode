// https://leetcode.com/problems/last-stone-weight/

import java.util.Arrays;

public class LastStoneWeight 
{
    public int lastStoneWeight(int[] stones) 
    {
        // Trivial cases
        if (stones.length == 1)
            return stones[0];
        else if (stones.length == 2)
            return Math.max(stones[0], stones[1]) - Math.min(stones[0], stones[1]);
        
        // Simulate the stone smashing
        int n = stones.length;
        int[] sortedStones = stones.clone();
        while (true)
        {
            Arrays.sort(sortedStones);
            if (sortedStones[n - 1] == 0 || sortedStones[n - 2] == 0)
                return Math.max(sortedStones[n - 1], sortedStones[n - 2]);
            else if (sortedStones[n - 1] > sortedStones[n - 2])
            {
                sortedStones[n - 1] -= sortedStones[n - 2];
                sortedStones[n - 2] = 0;
            }
            else if (sortedStones[n - 2] > sortedStones[n - 1])
            {
                sortedStones[n - 2] -= sortedStones[n - 1];
                sortedStones[n - 1] = 0;
            }
            else
            {
                sortedStones[n - 1] = 0;
                sortedStones[n - 2] = 0;
            }
        }
    }
}