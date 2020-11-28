// https://leetcode.com/problems/sliding-window-maximum/

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> values = new TreeMap<>();
        
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            values.put(nums[end], values.getOrDefault(nums[end], 0) + 1);
            if (end - start + 1 == k) {
                result.add(values.lastKey());
                if (values.get(nums[start]) == 1) {
                    values.remove(nums[start]);
                } else {
                    values.put(nums[start], values.get(nums[start]) - 1);
                }
                start++;
            }
        }
        
        int[] A = new int[result.size()];
        for (int i = 0; i < A.length; i++) {
            A[i] = result.get(i);
        }
        
        return A;
    }
}