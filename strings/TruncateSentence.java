// https://leetcode.com/problems/truncate-sentence/

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) == ' ' && --k == 0) {
                return s.substring(0, i);
            }
        }
        
        return s;
    } 
}
