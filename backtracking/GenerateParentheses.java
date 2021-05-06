// https://leetcode.com/problems/generate-parentheses/

import java.util.*;

public class GenerateParentheses {
    private int stringSize;
    private List<String> res;
    
    public List<String> generateParenthesis(int n) {
        stringSize = n * 2;
        res = new ArrayList<>();
        
        backtrack(new StringBuilder());
        
        return res;
    }
    
    public void backtrack(StringBuilder sb) {
        if (sb.length() == stringSize) {
            String s = sb.toString();
            if (isValidParentheses(s)) {
                res.add(s);
            }
        } else {
            sb.append('(');
            backtrack(sb);
            sb.deleteCharAt(sb.length() - 1);
            
            sb.append(')');
            backtrack(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public boolean isValidParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            
            if (count < 0) {
                return false;
            }
        }
        
        return count == 0;
    }    
}
