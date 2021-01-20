// https://leetcode.com/problems/longest-palindromic-substring/

import java.util.*;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        Pair longest = new Pair(0, 0);
        for (int i = 0; i < s.length(); i++) {
            Pair[] expanded = new Pair[]{expand(s, i, i), expand(s, i, i + 1)};
            Arrays.sort(expanded);
            if (expanded[1].y - expanded[1].x > longest.y - longest.x) {
                longest.x = expanded[1].x;
                longest.y = expanded[1].y;
            }
        }
        
        return s.substring(longest.x, longest.y + 1);
    }
    
    public Pair expand(String s, int i, int j) {
        int start = i;
        int end = j;
        Pair longest = new Pair(0, 0);
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                longest.x = start;
                longest.y = end;
                start--;
                end++;
            } else {
                break;
            }
        }
        
        return longest;
    }
    
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Pair p) {
            return Integer.compare(y - x, p.y - p.x);
        }
    }    
}
