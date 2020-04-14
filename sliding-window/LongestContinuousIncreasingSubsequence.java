// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

public class LongestContinuousIncreasingSubsequence 
{
    public int findLengthOfLCIS(int[] nums) 
    {
        int slow = 0, fast = 0, max = 0;
        while (fast < nums.length)
        {
            if (fast != 0 && nums[fast] <= nums[fast - 1])
                slow = fast;
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        
        return max;
    }
}