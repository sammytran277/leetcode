// https://leetcode.com/problems/unique-number-of-occurrences/

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) 
    {
        HashMap<Integer, Integer> intToCount = new HashMap<Integer, Integer>();
        HashSet<Integer> count = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++)
            intToCount.put(arr[i], intToCount.getOrDefault(arr[i], 0) + 1);
        
        for (int n : intToCount.values()) 
        {
            if (count.contains(n))
                return false;
            count.add(n);
        }
        
        return true;
    }
}