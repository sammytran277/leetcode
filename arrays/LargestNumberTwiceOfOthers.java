// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

public class LargestNumberTwiceOfOthers 
{
    public int dominantIndex(int[] nums) 
    {
        int n = nums.length;
        if (n == 1)
            return 0;

        int largestIndex = 0;
        
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > nums[largestIndex])
                largestIndex = i;
        }
        
        for (int i = 0; i < n; i++)
        {
            if (i == largestIndex)
                continue;
            if (2 * nums[i] > nums[largestIndex])
                return -1;
        }
        
        return largestIndex;
    }
}