// https://leetcode.com/problems/merge-strings-alternately/

public class MergeStringsAlternately {
    public String mergeAlternately(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int sPtr = 0;
        int tPtr = 0;
        while (sPtr < s.length() || tPtr < t.length()) {
            if (sPtr < s.length()) {
                sb.append(s.charAt(sPtr));
                sPtr++;
            }
            
            if (tPtr < t.length()) {
                sb.append(t.charAt(tPtr));
                tPtr++;
            }
        }
        
        return sb.toString();
    }
}