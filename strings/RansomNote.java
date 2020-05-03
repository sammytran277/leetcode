// https://leetcode.com/problems/ransom-note/

public class RansomNote 
{
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        int[] charFreq = new int[26];
        
        for (char c : ransomNote.toCharArray())
            charFreq[c - 'a']--;
        
        for (char c : magazine.toCharArray())
            charFreq[c - 'a']++;
        
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] < 0)
                return false;
        }
        
        return true;
    }
}