// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

import java.util.*;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> numFreq = new TreeMap<>();
        int longest = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            numFreq.put(nums[end], numFreq.getOrDefault(nums[end], 0) + 1);
            if (numFreq.lastKey() - numFreq.firstKey() <= limit) {
                longest = Math.max(longest, end - start + 1);
            } else {
                numFreq.put(nums[start], numFreq.get(nums[start]) - 1);
                if (numFreq.get(nums[start]) == 0) {
                    numFreq.remove(nums[start]);
                }
                
                start++;
            }
        }
        
        return longest;
    }
}