// https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString 
{
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> count = new HashMap<>();
            List<Integer> indices = new ArrayList<>();
            int lenS = s.length();
            int lenP = p.length();
            int lettersMatched = 0;
            
            // Trivial case
            if (lenS < lenP)
                return indices;
            
            // Add all chars of p as "costs"
            for (char c : p.toCharArray()) {
                count.put(c , count.getOrDefault(c, 0) + 1);
            }
            
            // Grow window until size lenP
            for (int i = 0; i < lenP; i++) {
                if (count.containsKey(s.charAt(i))) {
                    count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
                    if (count.get(s.charAt(i)) == 0)
                        lettersMatched++;
                }
            }
            
            // Check for first window being an anagram of p
            if (lettersMatched == count.size())
                indices.add(0);
            
            // Sliding window with fixed size
            for (int end = lenP; end < lenS; end++) {
                // Increase the window from the right by one
                if (count.containsKey(s.charAt(end))) {
                    count.put(s.charAt(end), count.get(s.charAt(end)) - 1);
                    if (count.get(s.charAt(end)) == 0)
                        lettersMatched++;
                }
                
                // Decrease the window from the left by one
                if (count.containsKey(s.charAt(end - lenP))) {
                    count.put(s.charAt(end - lenP), count.get(s.charAt(end - lenP)) + 1);
                    if (count.get(s.charAt(end - lenP)) == 1)
                        lettersMatched--;
                }
                
                // Check for matches
                if (lettersMatched == count.size())
                    indices.add(end - lenP + 1);
            }
            
            return indices;
        }
    }
}