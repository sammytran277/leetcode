// https://leetcode.com/problems/maximum-subarray/

public class MaximumSubArray 
{
    public int maxSubArray(int[] nums) 
    {
        // Solved using the sliding window technique
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int slow = 0;
        int fast = 0;

        // Widen the window 
        while (fast < nums.length)
        {
            windowSum += nums[fast];
            fast++;
            maxSum = Math.max(maxSum, windowSum);

            // Shrink the window as long as the window sum is negative
            while (slow < fast && windowSum < 0)
            {
                windowSum -= nums[slow];
                slow++;
            }
        }

        return maxSum;
    }
}