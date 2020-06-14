// https://leetcode.com/problems/largest-divisible-subset/

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        if (n == 0)
            return result;
        
        Arrays.sort(nums);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
        
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            maxIndex = count[i] > count[maxIndex] ? i : maxIndex;
        }

        int temp = nums[maxIndex];
        int currentCount = count[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (temp % nums[i] == 0 && count[i] == currentCount) {
                result.add(nums[i]);
                temp = nums[i];
                currentCount--;
            }
        }
        
        return result;
    } 
}