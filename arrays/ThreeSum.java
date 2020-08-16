// https://leetcode.com/problems/3sum/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> solutions = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int target = -1 * nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    solutions.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return solutions;
    }
}