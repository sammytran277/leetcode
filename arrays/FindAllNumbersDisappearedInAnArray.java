// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindAllNumbersDisappearedInAnArray 
{
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        ArrayList<Integer> missing = new ArrayList<Integer>();
        Arrays.sort(nums);
        
        for (int i = 1; i <= nums.length; i++) 
        {
            if (!binarySearch(nums, i))
                missing.add(i);
        }
        
        return missing;
    }
    
    public boolean binarySearch(int[] A, int n) 
    {
        int left = 0, right = A.length - 1, mid;
        while (left <= right) 
        {
            mid = left + (right - left) / 2;
            if (A[mid] == n)
                return true;
            else if (A[mid] > n)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return false;
    }
}