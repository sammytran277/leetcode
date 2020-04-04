// https://leetcode.com/problems/move-zeroes/

public class MoveZeroes 
{
    public void moveZeroes(int[] nums) 
    {
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length)
        {   
            if (nums[i] == 0 && nums[j] == 0)
                j++;
            else if (nums[i] == 0 && nums[j] != 0)
                swap(nums, i++, j++);
            else
            {
                i++;
                j++;
            }
        }
    }
    
    public void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}