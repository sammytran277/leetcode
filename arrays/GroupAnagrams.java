// https://leetcode.com/problems/group-anagrams/submissions/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams 
{
    // Idea is to map the sorted strings to an ArrayList
    public static List<List<String>> groupAnagrams(String[] strs) 
    {
        int n = strs.length;
        HashMap<String, ArrayList<String>> groups = new HashMap<String, ArrayList<String>>();
    
        char[] sorted;
        for (int i = 0; i < n; i++) 
        {
            sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            if (groups.containsKey(String.valueOf(sorted)))
                groups.get(String.valueOf(sorted)).add(strs[i]);
            else
                groups.put(String.valueOf(sorted), new ArrayList<String>(Arrays.asList(strs[i])));
        }
        
        List<List<String>> groupList = new ArrayList<List<String>>();
        for (String key : groups.keySet())
            groupList.add(groups.get(key));
        
        return groupList;
    }
}