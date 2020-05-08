// https://leetcode.com/problems/fizz-buzz/

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz
{
    public List<String> fizzBuzz(int n) 
    {
        ArrayList<String> ans = new ArrayList<String>();
        
        for (int i = 1; i < n + 1; i++)
        {
            if (i % 3 == 0 && i % 5 == 0)
                ans.add("FizzBuzz");
            else if (i % 3 == 0)
                ans.add("Fizz");
            else if (i % 5 == 0)
                ans.add("Buzz");
            else
                ans.add(String.valueOf(i));
        }
        
        return ans;
    }
}