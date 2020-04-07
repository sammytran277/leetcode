// https://leetcode.com/problems/maximum-product-subarray/

public class MaximumProductSubarray 
{
    public int maxProduct(int[] nums) 
    {
        int n = nums.length;
        
        // Edge cases
        if (n == 0)
            return 0;
        else if (n == 1)
            return nums[0];
        
        int temp;
        int globalMax = nums[0], localMax = nums[0], localMin = nums[0];
        
        /* Modified version of Kadane's algorithm to keep track of the local min
           which we need because two negative numbers have a positive product */
        for (int i = 1; i < n; i++)
        {
            temp = localMax;
            localMax = Math.max(Math.max(nums[i] * localMax, nums[i] * localMin), nums[i]);
            localMin = Math.min(Math.min(nums[i] * temp, nums[i] * localMin), nums[i]); 
                
            if (localMax > globalMax)
                globalMax = localMax;
        }
        
        return globalMax;
    }
}
}