// https://leetcode.com/problems/happy-number/

import java.util.HashSet;

public class HappyNumbers
{
    public static boolean isHappy(int n) 
    {
        HashSet<Integer> sums = new HashSet<Integer>();
        
        int digitSum;
        char[] nChars;
        while (n != 1)
        {
            digitSum = 0;
            nChars = String.valueOf(n).toCharArray();
            for (char c : nChars)
                digitSum += Character.getNumericValue(c) * Character.getNumericValue(c);
            if (!sums.contains(digitSum))
                sums.add(digitSum);
            else
                return false;
            n = digitSum;
        }

        return true;
    }
}