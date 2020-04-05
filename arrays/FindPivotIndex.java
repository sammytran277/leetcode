// https://leetcode.com/problems/find-pivot-index/

public class FindPivotIndex 
{
    public int pivotIndex(int[] nums) 
    {
        int n = nums.length;
        
        // Handle edge cases
        if (n == 0 || n == 2)
            return -1;
        else if (n == 1)
            return 0;
        
        // Get the right sum
        int leftSum = 0, rightSum = 0;
        for (int i = 1; i < n; i++)
            rightSum += nums[i];
        
        // Checks indexes 0 through n - 2
        for (int i = 0; i < n - 1; i++)
        {
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
            rightSum -= nums[i + 1];
        }
        
        // Check if last index is the pivot
        if (leftSum == rightSum)
            return n - 1;
        else
            return -1;
    }
}