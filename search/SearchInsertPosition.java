// https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int smallestIndex = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= target) {
                smallestIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return smallestIndex;
    }
}