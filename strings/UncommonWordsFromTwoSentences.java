// https://leetcode.com/problems/uncommon-words-from-two-sentences/

import java.util.HashMap;
import java.util.ArrayList;

public class UncommonWordsFromTwoSentences {
    // Just return the words with a frequency of 1
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> wordFreq = new HashMap<>();
        for (String s : A.split(" "))
            wordFreq.put(s, wordFreq.getOrDefault(s, 0) + 1);
        for (String s : B.split(" "))
            wordFreq.put(s, wordFreq.getOrDefault(s, 0) + 1);
        
        ArrayList<String> uncommon = new ArrayList<>();
        for (String key : wordFreq.keySet()) {
            if (wordFreq.get(key) == 1)
                uncommon.add(key);
        }
        
        return uncommon.toArray(new String[uncommon.size()]);
    }
}