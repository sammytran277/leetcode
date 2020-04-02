// https://leetcode.com/problems/rotate-array/

public class RotateArray 
{
    public void rotate(int[] nums, int k) 
    {
        int[] aux = nums.clone();
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % nums.length] = aux[i];
    }
}