// https://leetcode.com/problems/4sum/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int a = nums[i];
            List<List<Integer>> triplets = threeSum(nums, target - a, i + 1);
            if (triplets.size() != 0) {
                for (List<Integer> triplet : triplets) {
                    triplet.add(a);
                    res.add(triplet);
                }
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        int n = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();
        
        for (int i = start; i < n; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int b = nums[i];
            int c = i + 1;
            int d = n - 1;
            
            while (c < d) {
                int sum = b + nums[c] + nums[d];
                if (sum < target) {
                    c++;
                } else if (sum > target) {
                    d--;
                } else {
                    triplets.add(new ArrayList<Integer>(Arrays.asList(b, nums[c], nums[d])));
                    c++;
                    while (c < d && nums[c] == nums[c - 1]) {
                        c++;
                    }
                }
            }
        }

        return triplets;
    }
}