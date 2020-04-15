// https://leetcode.com/problems/longest-common-prefix/
 
public class LongestCommonPrefix
{
    public String longestCommonPrefix(String[] strs) 
    {
        // Trivial case
        if (strs.length == 0)
            return "";
        
        StringBuilder prefix = new StringBuilder();
        int minLength = Integer.MAX_VALUE;

        // Prefix size is upper bounded by the size of the smallest string
        for (String s : strs)
            minLength = Math.min(minLength, s.length());

        // Iterate through each string, checking that each index's char is the same
        for (int i = 0; i < minLength; i++)
        {
            for (int j = 0; j < strs.length; j++)
            {
                if (strs[j].charAt(i) != strs[0].charAt(i))
                    return (prefix.length() == 0) ? "" : prefix.toString();
            }
            
            prefix.append(strs[0].charAt(i));
        }
        
        return (prefix.length() == 0) ? "" : prefix.toString();
    }
}