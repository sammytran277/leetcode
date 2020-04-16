// https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParentheses 
{
    public boolean isValid(String s) 
    {
        Stack<Character> left = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                left.push(s.charAt(i));
            else if (left.empty())
                return false;
            else if (s.charAt(i) == ')' && left.peek() == '(')
                left.pop();
            else if (s.charAt(i) == ']' && left.peek() == '[')
                left.pop();
            else if (s.charAt(i) == '}' && left.peek() == '{')
                left.pop();
            else
                return false;
        }
        
        return left.empty();
    }
}