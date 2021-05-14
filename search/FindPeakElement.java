// https://leetcode.com/problems/find-peak-element/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int left = (mid - 1 >= 0) ? nums[mid - 1] : Integer.MIN_VALUE;
            int right = (mid + 1 <= nums.length - 1) ? nums[mid + 1] : Integer.MIN_VALUE;
            if (left <= nums[mid] && nums[mid] >= right) {
                return mid;
            } else if (nums[mid] <= right) {
                low = mid + 1;
            } else {
                high = mid - 1;                
            }
        }
        
        return -1;
    }
}
