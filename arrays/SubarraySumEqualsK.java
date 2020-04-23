// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;

public class SubarraySumEqualsK 
{
    public int subarraySum(int[] nums, int k) 
    {
        HashMap<Integer, Integer> prefix = new HashMap<Integer, Integer>();
        int currSum = 0, count = 0;
        
        for (int i = 0; i < nums.length; i++) 
        {
            currSum += nums[i];
            if (currSum == k)
                count++;
            if (prefix.containsKey(currSum - k)) 
                count += prefix.get(currSum - k);
            prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
}