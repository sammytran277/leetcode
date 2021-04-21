// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String s) {
        boolean[] seen = new boolean[26];
        for (int i = 0, n = s.length(); i < n; i++) {
            seen[s.charAt(i) - 'a'] = true;
        }
        
        for (int i = 0; i < seen.length; i++) {
            if (!seen[i]) {
                return false;
            }
        }
        
        return true;
    }    
}
