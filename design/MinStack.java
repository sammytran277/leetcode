// https://leetcode.com/problems/min-stack/

import java.util.LinkedList;

public class MinStack 
{
    LinkedList<Integer> stack;
    int indexOfMin;

    // Constructor
    public MinStack() 
    {
        stack = new LinkedList<Integer>();
        indexOfMin = -1;
    }
    
    // Push an int onto the stack
    public void push(int x) 
    {
        if (indexOfMin == -1)
            indexOfMin = 0;
        else if (x < (int) stack.get(indexOfMin))
            indexOfMin = stack.size();
        stack.add(x);
    }
    
    // Pop the last int from the stack
    public void pop() 
    {
        stack.removeLast();
        // Find the new min if we popped it off the stack
        if (indexOfMin >= stack.size())
        {
            // If the stack is empty, there is no min
            if (stack.size() == 0)
            {
                indexOfMin = -1;
                return;
            }
            
            // Iterate through the stack to find the index of the new min
            int newMin = Integer.MAX_VALUE;
            for (int i = 0; i < stack.size(); i++)
            {
                if ((int) stack.get(i) <= newMin)
                {
                    indexOfMin = i;
                    newMin = (int) stack.get(i);
                }
            }
        }
    }
    
    // Peek at the last int on the stack
    public int top() 
    {
        return (int) stack.peekLast();
    }
    
    // Return the int with the lowest value from the stack
    public int getMin() 
    {
        return (int) stack.get(indexOfMin);
    }
}