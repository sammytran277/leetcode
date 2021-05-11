// https://leetcode.com/problems/implement-strstr/

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < m - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        
        return (needle.equals("")) ? 0 : -1;
    }    
}
