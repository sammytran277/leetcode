// https://leetcode.com/problems/contiguous-array/

import java.util.HashMap;

public class ContiguousArray 
{
    public int findMaxLength(int[] nums) 
    {
        int count = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> countToIndex = new HashMap<Integer, Integer>();
        countToIndex.put(0, -1);
        
        /* Key insight is that, when you plot the count, values with the same y-axis value
           correspond to subarrays with the same number of 0s and 1s. We'll store these values
           in a hashmap and keep track of the biggest subarray we've seen so far */
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
                count--;
            else
                count++;

            if (countToIndex.containsKey(count))
                maxLength = Math.max(maxLength, i - countToIndex.get(count));
            else
                countToIndex.put(count, i);
        }

        return maxLength;
    }
}