// https://leetcode.com/problems/string-to-integer-atoi/

public class StringToInteger 
{
    public int myAtoi(String str) 
    {
        boolean containsInt = false;
        StringBuilder newInt = new StringBuilder();
        
        // Build the new int 
        for (int i = 0; i < str.length(); i++)
        {
            // Ignore leading whitespace
            if (str.charAt(i) == ' ' && newInt.length() == 0)
                continue;
            // Sign the int
            else if ((str.charAt(i) == '-' || str.charAt(i) == '+') && newInt.length() == 0)
                newInt.append(str.charAt(i));
            // Add digit to the int we are building
            else if (Character.isDigit(str.charAt(i)))
            {
                newInt.append(str.charAt(i));
                containsInt = true;
            }
            // Trailing non-digit chars end the loop
            else if (newInt.length() != 0)
                break;
            // Leading non-digit chars return 0
            else
                return 0;
        }

        if (!containsInt)
            return 0;
        
        try 
        {
            return Integer.parseInt(newInt.toString());
        } 
        catch (Exception e) 
        {
            if (newInt.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
    }
}