// https://leetcode.com/problems/unique-morse-code-words/

import java.util.*;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        HashSet<String> unique = new HashSet<>();
        for (String word : words) {
            int N = word.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(morse[word.charAt(i) - 'a']);
            }
            
            unique.add(sb.toString());
        }
        
        return unique.size();
    }
}