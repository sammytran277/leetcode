// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchRotatedSortedArray
{
    public int search(int[] nums, int target) 
    {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[left] == target)
                return left;
            else if (nums[right] == target)
                return right;
            else if (target > nums[left] && target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid] && target < nums[right])
                left = mid + 1;
            else if (target < nums[left] && target < nums[right] && nums[left] > nums[mid])
                right = mid - 1;
            else if (target > nums[left] && target > nums[mid] && nums[left] > nums[mid])
                right = mid - 1;
            else if (target < nums[left] && target < nums[mid] && nums[left] > nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
}