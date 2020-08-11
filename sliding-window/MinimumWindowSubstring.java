// https://leetcode.com/problems/minimum-window-substring/

import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        int start = 0;
        int lettersMatched = 0;
        int lenS = s.length();
        int lenT = t.length();
        String substr = "";
        
        // Trivial case
        if (lenT > lenS)
            return substr;
        
        // Add all the characters in t to the map
        for (char c : t.toCharArray())
            count.put(c, count.getOrDefault(c, 0) + 1);   
        
        // Sliding window
        for (int end = 0; end < lenS; end++) {
            // Grow the window and adjust values in map
            if (count.containsKey(s.charAt(end))) {
                count.put(s.charAt(end), count.get(s.charAt(end)) - 1);
                if (count.get(s.charAt(end)) == 0)
                    lettersMatched++;
            }
            
            // Shrink the window
            while (lettersMatched == count.size()) {
                // Keep track of smallest substring
                if (substr.length() == 0 || end - start + 1 < substr.length())
                    substr = s.substring(start, end + 1);
                
                // Adjust values in map
                if (count.containsKey(s.charAt(start))) {
                    if (count.get(s.charAt(start)) == 0)
                        lettersMatched--;
                    count.put(s.charAt(start), count.get(s.charAt(start)) + 1);
                }
                
                start++;
            }
        }
        
        return substr;
    }
}