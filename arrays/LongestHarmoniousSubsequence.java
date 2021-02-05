// https://leetcode.com/problems/longest-harmonious-subsequence/

import java.util.*;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        
        for (int key : numFreq.keySet()) {
            if (numFreq.containsKey(key + 1)) {
                longest = Math.max(longest, numFreq.get(key) + numFreq.get(key + 1));
            }
        }
        
        return longest;
    }
}
