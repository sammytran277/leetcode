// https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];
        int maxRepeatCount = 0;
        int start = 0;
        int longest = 0;
        int n = s.length();
        
        for (int end = 0; end < n; end++) {
            charFreq[s.charAt(end) - 'A']++;
            
            // Keep track of the letter that appears most often in the window
            if (charFreq[s.charAt(end) - 'A'] >= maxRepeatCount) {
                maxRepeatCount = charFreq[s.charAt(end) - 'A'];
            }
            
            // Shrink the window while there are no replacements left
            while (end - start + 1 - maxRepeatCount > k) {
                charFreq[s.charAt(start) - 'A']--;
                start++;
            }
            
            longest = Math.max(longest, end - start + 1);
        }
        
        return longest;
    }
}