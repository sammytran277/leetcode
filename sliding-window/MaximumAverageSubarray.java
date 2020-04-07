// https://leetcode.com/problems/maximum-average-subarray-i/

public class MaximumAverageSubarray 
{
    // Simple example of sliding window technique to avoid duplicate work
    public static double findMaxAverage(int[] nums, int k) 
    {
        int n = nums.length;
        double currSum = 0;
        for (int i = 0; i < k; i++)
            currSum += nums[i];
        double maxSum = currSum;
        
        for (int i = k; i < n; i++)
        {
            currSum += nums[i] - nums[i - k];
            maxSum = Math.max(currSum, maxSum);
        }
        
        return maxSum / k;
    }

}