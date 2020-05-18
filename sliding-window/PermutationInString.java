// https://leetcode.com/problems/permutation-in-string/

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String p, String s) {
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        int slow = 0, fast = -1;
        
        // Trivial case
        if (s.length() < p.length()) 
            return false;
        
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
                    return true;
                if (charFreq.get(s.charAt(slow)) == 0) 
                    missing++;
                charFreq.put(s.charAt(slow), charFreq.get(s.charAt(slow)) + 1);
                slow++;
            }
        }
        
        return false;
    }
}