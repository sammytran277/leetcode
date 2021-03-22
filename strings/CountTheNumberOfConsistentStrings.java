// https://leetcode.com/problems/count-the-number-of-consistent-strings/

import java.util.*;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        
        int count = 0;
        outer: for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    continue outer;
                }
            }
            
            count++;
        }
        
        return count;
    }
}