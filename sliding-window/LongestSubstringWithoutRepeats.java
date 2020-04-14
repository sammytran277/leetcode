// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;

public class LongestSubstringWithoutRepeats 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int slow = 0, fast = 0, max = 0;
        HashSet<Character> windowChars = new HashSet<Character>();
        while (fast < s.length())
        {
            if (windowChars.contains(s.charAt(fast)))
            {
                windowChars.remove(s.charAt(slow));
                slow++;
                continue;
            }
            max = Math.max(max, fast - slow + 1);
            windowChars.add(s.charAt(fast));
            fast++;
        }
        
        return max;
    }
}