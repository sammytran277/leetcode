public class MaximumSumCircularSubarray 
{
    public int maxSubarraySumCircular(int[] A) 
    {
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        int localMin = 0, globalMin = Integer.MAX_VALUE;
        int total = 0;
        
        /* Idea is to split the problem into two cases:
           Case #1: The max sum is not circular, so we can just use Kadane's
           Case #2: The max sum is circular, so it is equal to totalSum(A) - minSum(A)
           Edge Case: The entire array is negative, so totalSum(A) - globalMin(A) = 0
        */
        for (int i = 0; i < A.length; i++) 
        {
            localMax = Math.max(localMax + A[i], A[i]);
            globalMax = Math.max(localMax, globalMax);
            localMin = Math.min(localMin + A[i], A[i]);
            globalMin = Math.min(localMin, globalMin);
            total += A[i];
        }
        
        return (globalMax > 0) ? Math.max(globalMax, total - globalMin) : globalMax;
    }
}