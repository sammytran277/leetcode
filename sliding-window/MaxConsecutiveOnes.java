// https://leetcode.com/problems/max-consecutive-ones/

public class MaxConsecutiveOnes 
{
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int slow = 0, fast = 0, maxOnes = 0;
        
        while (fast < nums.length)
        {
            if (nums[fast] != 1)
                slow = fast + 1;
            fast++;
            maxOnes = Math.max(maxOnes, fast - slow);
        }
                
        return maxOnes;
    }
}