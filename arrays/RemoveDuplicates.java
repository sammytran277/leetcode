// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicates
{
    public int removeDuplicates(int[] nums) 
    {
        int i = 0;
        if (nums.length == 0)
            return i;
        for (int j = 0; j < nums.length; j++)
        {
            if (j == nums.length - 1 || nums[j] != nums[j + 1])
                nums[i++] = nums[j];
        }
        return i;
    }
}