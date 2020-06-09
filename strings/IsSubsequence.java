// https://leetcode.com/problems/is-subsequence/

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0)
            return true;
        else if (n == 0)
            return false;
        
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (t.charAt(i) == s.charAt(ptr))
                ptr++;
            if (ptr == m)
                return true;
        }
        
        return false;
    }    
}