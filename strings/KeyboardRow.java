// https://leetcode.com/problems/keyboard-row/

import java.util.*;

public class KeyboardRow {
    private String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (canBeTypedInOneRow(word.toLowerCase())) {
                res.add(word);
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
    
    public boolean canBeTypedInOneRow(String word) {
        outer: for (String row : rows) {
            for (int i = 0; i < word.length(); i++) {
                if (row.indexOf(word.charAt(i)) == -1) {
                    continue outer;
                }
            }
            
            return true;
        }
        
        return false;
    }    
}
