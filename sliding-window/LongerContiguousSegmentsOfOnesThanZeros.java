// https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/

public class LongerContiguousSegmentsOfOnesThanZeros {
    public boolean checkZeroOnes(String s) {
        return longestSegment(s, '1') > longestSegment(s, '0');
    }
    
    public int longestSegment(String s, char c) {
        int longest = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (s.charAt(end) != c) {
                start = end + 1;
            }
            
            longest = Math.max(longest, end - start + 1);
        }
        
        return longest;
    }    
}