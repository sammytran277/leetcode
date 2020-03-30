// https://leetcode.com/problems/valid-anagram/

import java.util.HashMap;

class ValidAnagram
{
    public boolean isAnagram(String s, String t) 
    {
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> sFreq = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tFreq = new HashMap<Character, Integer>();

        // Hash all the characters in s and t
        for (int i = 0; i < s.length(); i++)
        {
            if (!sFreq.containsKey(s.charAt(i)))
                sFreq.put(s.charAt(i), 1);
            else
                sFreq.put(s.charAt(i), sFreq.get(s.charAt(i)) + 1);
            if (!tFreq.containsKey(t.charAt(i)))
                tFreq.put(t.charAt(i), 1);
            else
                tFreq.put(t.charAt(i), tFreq.get(t.charAt(i)) + 1);
        }

        // Check that the frequency of both letters are the same
        for (char key : sFreq.keySet())
        {
            if (!sFreq.get(key).equals(tFreq.get(key)))
                return false;
        }

        return true;
    }
}