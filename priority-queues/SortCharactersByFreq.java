// https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class SortCharactersByFreq 
{
    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        PriorityQueue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character a, Character b) 
            {
                if (charFreq.get(a) > charFreq.get(b))
                    return -1;
                else if (charFreq.get(a) < charFreq.get(b)) 
                    return 1;
                else
                    return 0;
            }
        });
        
        // Map each char to its letter frequency
        for (char c : s.toCharArray())
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        
        // Add each char to a max priority queue with a custom Comparator
        for (char c : charFreq.keySet())
            pq.add(c);
        
        // Create output string
        StringBuilder sb = new StringBuilder();
        while (pq.peek() != null) 
        {
            char c = pq.poll();
            for (int i = 0; i < charFreq.get(c); i++)
                sb.append(c);
        }
        
        return sb.toString();
    }
}