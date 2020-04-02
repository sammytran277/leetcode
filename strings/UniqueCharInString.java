import java.util.HashMap;

class UniqueCharInString
{
    public int firstUniqChar(String s) 
    {
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        for (char c : s.toCharArray())
        {
            if (charFreq.containsKey(c))
                charFreq.put(c, charFreq.get(c) + 1);
            else
                charFreq.put(c, 1);
        }

        for (char c : s.toCharArray())
        {
            if (charFreq.get(c) == 1)
                return s.indexOf(c);
        }

        return -1;
    }
}