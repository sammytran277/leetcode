// https://leetcode.com/problems/shortest-distance-to-a-character/

import java.util.*;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                set.add(i);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            int before = (set.floor(i) != null) ? i - set.floor(i) : s.length();
            int after = (set.ceiling(i) != null) ? set.ceiling(i) - i : s.length();
            res[i] = Math.min(before, after);
        }
            
        return res;
    }    
}
