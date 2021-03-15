// https://leetcode.com/problems/determine-if-string-halves-are-alike/

import java.util.*;

public class DetermineIfStringHalvesAreAlike {
    class Solution {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        public boolean halvesAreAlike(String s) {
            int firstHalfOdds = 0;
            int secondHalfOdds = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i < s.length() / 2) {
                    firstHalfOdds += (isVowel(s.charAt(i))) ? 1 : 0;
                } else {
                    secondHalfOdds += (isVowel(s.charAt(i))) ? 1 : 0;
                }
            }
            
            return firstHalfOdds == secondHalfOdds;
        }
        
        public boolean isVowel(char c) {
            return set.contains(c);
        }
    }
}
