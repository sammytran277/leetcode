// https://leetcode.com/problems/permutation-in-string/

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] charFreq = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
            
        // Trivial case
        if (len1 > len2)
            return false;
            
        // Bring the window up to size len1
        for (int i = 0; i < len1; i++) {
            charFreq[s1.charAt(i) - 'a']++;
            charFreq[s2.charAt(i) - 'a']--;
        }
    
        if (isMatch(charFreq))
            return true;     
            
        // Slide the window over by 1
        for (int i = len1; i < len2; i++) {
            charFreq[s2.charAt(i) - 'a']--;
            charFreq[s2.charAt(i - len1) - 'a']++;
            if (isMatch(charFreq))
                return true;
        }
    
        return false;
    }
    
    public boolean isMatch(int[] A) {
        for (int i = 0; i < 26; i++) {
            if (A[i] != 0)
                return false;
        }
    
        return true;
    }
}