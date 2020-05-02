// https://leetcode.com/problems/jewels-and-stones/

import java.util.HashSet;

public class JewelsAndStones 
{
    public int numJewelsInStones(String J, String S) 
    {
        HashSet<Character> jewelChars = new HashSet<Character>();
        for (char c : J.toCharArray())
            jewelChars.add(c);
        
        int numJewels = 0;
        for (char c : S.toCharArray()) 
        {
            if (jewelChars.contains(c)) 
                numJewels++;
        }
        
        return numJewels;
    }
}