// https://leetcode.com/problems/second-largest-digit-in-a-string/

import java.util.*;

public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        TreeSet<Integer> nums = new TreeSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                nums.add(c - '0');
            }
        }
        
        if (nums.size() <= 1) {
            return -1;
        }

        return nums.lower(nums.last());
    }    
}
