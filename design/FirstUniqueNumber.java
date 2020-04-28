// 30-Day LeetCoding Challenge Day 28

import java.util.LinkedHashMap;

public class FirstUniqueNumber 
{
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    public void FirstUnique(int[] nums) 
    {
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    public int showFirstUnique() 
    {
        for (int key : map.keySet())
        {
            if (map.get(key) == 1)
                return key;
        }
        
        return -1;
    }
    
    public void add(int value) 
    {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}