// https://leetcode.com/problems/letter-case-permutation/

import java.util.*;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        Set<String> res = new HashSet<>();
        for (int mask = 0; mask < (1 << s.length()); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if ((mask & (1 << i)) == 0) {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                } else {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }
            }
            
            res.add(sb.toString());
        }
        
        return new ArrayList<>(res);
    }    
}
