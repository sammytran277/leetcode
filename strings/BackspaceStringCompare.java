// https://leetcode.com/problems/backspace-string-compare/

public class BackspaceStringCompare 
{
    public boolean backspaceCompare(String S, String T) 
    {
        StringBuilder realS = new StringBuilder();
        StringBuilder realT = new StringBuilder();
        
        // Build the actual string for S
        for (int i = 0; i < S.length(); i++)
        {
            if (realS.length() > 0 && S.charAt(i) == '#')
                realS.deleteCharAt(realS.length() - 1);
            else if (S.charAt(i) != '#')
                realS.append(S.charAt(i));
        }
        
        // Build the actual string for T
        for (int i = 0; i < T.length(); i++)
        {
            if (realT.length() > 0 && T.charAt(i) == '#')
                realT.deleteCharAt(realT.length() - 1);
            else if (T.charAt(i) != '#')
                realT.append(T.charAt(i));
        }
        
        // Compare the actual strings
        if (realS.toString().equals(realT.toString()))
            return true;
        else
            return false;
    }
}