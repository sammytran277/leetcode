// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s, String t) {
        int n = s.length();
        int diff = 0;
        int[] charFreq = new int[26];
        
        for (int i = 0; i < n; i++) {
            diff += (s.charAt(i) != t.charAt(i)) ? 1 : 0;
            charFreq[s.charAt(i) - 'a']++;
            charFreq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] != 0) {
                return false;
            }
        }
        
        return diff <= 2;
    }
}