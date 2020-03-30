// https://leetcode.com/problems/valid-anagram/

public class ValidAnagram
{
    public boolean isAnagram(String s, String t) 
    {
        if (s.length() != t.length())
            return false;
        
        int[] charFreq = new int[26];

        // Increment counter for s, decrement for t
        for (int i = 0; i < s.length(); i++)
        {
            charFreq[s.charAt(i) - 'a']++;
            charFreq[t.charAt(i) - 'a']--;
        }

        // Check the frequency of all chars is 0
        for (int n : charFreq)
        {
            if (n != 0)
                return false;
        }

        return true;
    }
}