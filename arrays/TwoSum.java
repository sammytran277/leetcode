// https://leetcode.com/problems/two-sum/

import java.util.HashMap;

public class TwoSum
{
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++)
        {
            if (valToIndex.containsKey(target - nums[i]) && valToIndex.get(target - nums[i]) != i)
                return new int[]{valToIndex.get(target - nums[i]), i};
            valToIndex.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}