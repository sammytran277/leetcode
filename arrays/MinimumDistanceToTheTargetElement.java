// https://leetcode.com/problems/minimum-distance-to-the-target-element/

public class MinimumDistanceToTheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int left = start;
        int right = start;
        while (left >= 0 || right < nums.length) {
            if (left >= 0 && nums[left] == target) {
                return start - left;
            } else if (right < nums.length && nums[right] == target) {
                return start;
            }
            
            left--;
            right++;
        }
        
        return -1;
    }
}
