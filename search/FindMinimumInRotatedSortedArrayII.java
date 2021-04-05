// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
            } else if (nums[low] < nums[high]) {
                return nums[low];
            } else if (nums[low] > nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return nums[low];
    }
}