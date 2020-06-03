// https://leetcode.com/problems/remove-k-digits/

import java.util.Stack;

public class RemoveKDigits 
{
    public String removeKdigits(String num, int k) 
    {
        // Trivial cases
        if (num.length() == 0 || num.length() == k)
            return "0";
        
        Stack<Character> stack = new Stack<Character>();
        
        int i = 0;
        while (i < num.length())
        {
            /* Idea is go left to right and remove the previous digit 
               if its larger than the current digit */
            while (k > 0 && !stack.empty() && stack.peek() > num.charAt(i))
            {
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i));
            i++;
        }
        
        // Handle cases where all the numbers are the same, e.g '11111'
        while (k > 0)
        {
            stack.pop();
            k--;
        }
        
        StringBuilder digits = new StringBuilder();
        
        while (!stack.empty())
            digits.append(stack.pop());
        
        digits.reverse();
        
        // Remove any leading zeroes
        while (digits.length() > 1 && digits.charAt(0) == '0')
            digits.deleteCharAt(0);
        
        return digits.toString();
    }
}