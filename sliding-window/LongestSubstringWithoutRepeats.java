// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

public class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        int start = 0;
        int longest = 0;
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int end = 0; end < N; end++) {
            char c = s.charAt(end);
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= start) {
                start = lastIndex.get(c) + 1;
            }
            
            lastIndex.put(s.charAt(end), end);
            longest = Math.max(longest, end - start + 1);
        }
        
        return longest;
    }
}