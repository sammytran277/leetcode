// https://leetcode.com/problems/backspace-string-compare/

public class BackspaceStringCompare 
{
    public boolean backspaceCompare(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
    
        return build(S, sLen).equals(build(T, tLen));
    }
    
    public String build(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int backspaces = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                backspaces++;
            } else if (backspaces > 0) {
                backspaces--;
            } else {
                sb.append(s.charAt(i));
            }
        }
    
        return sb.toString();
    }
}