// https://leetcode.com/problems/maximum-69-number/

public class Maximum69Number 
{
    public int maximum69Number (int num) 
    {
        boolean alreadyReplaced = false;
        StringBuilder max = new StringBuilder();
        for (char d : Integer.toString(num).toCharArray())
        {
            if (d == '6' && !alreadyReplaced)
            {
                max.append('9');
                alreadyReplaced = true;
            }
                
            max.append(d);
        }

        return Integer.parseInt(max.toString());
    }
}