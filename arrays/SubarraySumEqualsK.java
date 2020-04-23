// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;

public class SubarraySumEqualsK 
{
    public int subarraySum(int[] nums, int k) 
    {
        HashMap<Integer, Integer> prefix = new HashMap<Integer, Integer>();
        int currSum = 0, count = 0;
        
        /* Idea is to keep a table mapping a sum to its number of occurrences.
           This allows you to iterate through the array once and check if the complement
           is in the table. If it is, then it is possible to make the target, k */
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