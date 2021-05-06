// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    private int n;
    private List<String> res;
    private Map<Character, List<Character>> map = new HashMap<>() {
        {
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z')); 
        }
    };
    
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        backtrack(digits, 0, new StringBuilder());
        
        return res;
    }
    
    public void backtrack(String digits, int i, StringBuilder sb) {
        if (i == n) {
            res.add(sb.toString());        
        } else {
            for (char c : map.get(digits.charAt(i))) {
                sb.append(c);
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}