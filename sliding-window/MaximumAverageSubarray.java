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
        
        // If n = k, then we just return the average of the entire array
        if (n == k)
            return currSum / k;
        
        int slow = 0, fast = k;
        while (fast < n)
        {
            currSum = currSum + nums[fast++] - nums[slow++];
            if (currSum > maxSum)
                maxSum = currSum;
        }
        
        return maxSum / k;
    }

}