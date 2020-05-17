// https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString 
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        int slow = 0, fast = -1;
        
        // Trivial case
        if (s.length() < p.length()) 
            return indexes;
        
        // Get char frequency of p
        for (char c : p.toCharArray())
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        
        int missing = charFreq.size();
        while (fast < s.length() - 1) 
        {
            // Widen the window if the fast pointer is pointing at a char in p
            fast++;
            if (charFreq.containsKey(s.charAt(fast))) 
            {
                charFreq.put(s.charAt(fast), charFreq.get(s.charAt(fast)) - 1);
                if (charFreq.get(s.charAt(fast)) == 0) 
                    missing--;
            } 
            else 
            {
                // Shrink the window while a char that is not in p is in the window
                while (slow <= fast) 
                {
                    if (charFreq.containsKey(s.charAt(slow))) 
                    {
                        if (charFreq.get(s.charAt(slow)) == 0) 
                            missing++;
                        charFreq.put(s.charAt(slow), charFreq.get(s.charAt(slow)) + 1);
                    }
                    
                    slow++;
                }
            }

            // Once the window is of size p, check if it is an anagram of p
            if (fast - slow + 1 == p.length()) 
            {
                if (missing == 0) 
                    indexes.add(slow);
                if (charFreq.get(s.charAt(slow)) == 0) 
                    missing++;
                charFreq.put(s.charAt(slow), charFreq.get(s.charAt(slow)) + 1);
                slow++;
            }
        }
        
        return indexes;
    }
}