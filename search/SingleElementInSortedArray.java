// https://leetcode.com/problems/single-element-in-a-sorted-array/

public class SingleElementInSortedArray 
{
    public int singleNonDuplicate(int[] nums) 
    {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        
        // Idea is to examine the index of mid to see where the distinct value is
        while (low <= high) 
        {
            mid = low + (high - low) / 2;
            
            // Only one element left to check when we reach the array boundaries
            if (mid == 0 || mid == nums.length - 1)
                return nums[mid];
            
            // We're on the left side of a duplicate pair
            if (nums[mid] == nums[mid + 1]) 
            {
                if (mid % 2 == 0)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            // We're on the right side of a duplicate pair
            else if (nums[mid] == nums[mid - 1]) 
            {
                if (mid % 2 == 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // We've found the distinct value
            else
                return nums[mid];
        }
        
        return -1;
    }    
}

