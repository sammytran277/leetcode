// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);
            
            if (c1 != c2 && c1 != c3 && c2 != c3) {
                res++;
            }
        }
        
        return res;
    }    
}