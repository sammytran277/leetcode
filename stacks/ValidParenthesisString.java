// https://leetcode.com/problems/valid-parenthesis-string/

import java.util.Stack;

public class ValidParenthesisString
{
    public boolean checkValidString(String s) 
    {
        /* Idea is to keep track of the indices 
           of the left parentheses and the asterisks */
        Stack<Integer> leftParens = new Stack<Integer>();
        Stack<Integer> asterisks = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
                leftParens.push(i);
            else if (s.charAt(i) == '*')
                asterisks.push(i);
            else
            {
                /* If we can pop a left parenthesis, we should try to
                   do that because the asterisks are more flexible */
                if (!leftParens.empty() && leftParens.peek() < i)
                    leftParens.pop();
                // No left parentheses to pop, so we have to pop an asterisk
                else if (!asterisks.empty() && asterisks.peek() < i)
                    asterisks.pop();
                // If you can't pop either, the string is invalid
                else
                    return false;
            }
        }
        
        /* In some cases, like "(*)(", there are left parentheses and
           asterisks left over. We can pop a left parenthesis with an asterisk
           if and only if the asterisk comes after the left parenthesis */
        while (!leftParens.empty() && !asterisks.empty())
        {
            if (asterisks.peek() < leftParens.peek())
                return false;
            leftParens.pop();
            asterisks.pop();
        }
        
        return leftParens.empty();
    }
}