// https://leetcode.com/problems/maximum-subarray/

public class MaximumSubArray 
{
    public int maxSubArray(int[] nums) 
    {
        // Solved with an implementation of Kadane's Algorithm
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            localMax = Math.max(nums[i], localMax + nums[i]);
            if (localMax > globalMax)
                globalMax = localMax;
        } 
        return globalMax;
    }
}