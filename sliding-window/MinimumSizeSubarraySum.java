// https://leetcode.com/problems/minimum-size-subarray-sum/

public class MinimumSizeSubarraySum 
{
    public int minSubArrayLen(int s, int[] nums) 
    {
        int slow = 0, fast = 0, windowSum = 0, minLength = Integer.MAX_VALUE;
        while (fast < nums.length)
        {
            windowSum += nums[fast];
            
            while (windowSum >= s)
            {
                minLength = Math.min(minLength, fast - slow + 1);
                windowSum -= nums[slow++];
            }
            
            fast++;
        }
        
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength; 
    }
}