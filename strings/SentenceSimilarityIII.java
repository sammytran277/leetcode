// https://leetcode.com/problems/sentence-similarity-iii/

public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] w1 = s1.split(" ");
        String[] w2 = s2.split(" ");
        
        if (w1.length > w2.length) {
            return solve(w2, w1);
        }
        
        return solve(w1, w2);
    }
    
    public boolean solve(String[] shorter, String[] longer) {
        int l1 = 0;
        int l2 = 0;
        int r1 = shorter.length - 1;
        int r2 = longer.length - 1;
        
        while (l1 < shorter.length && shorter[l1].equals(longer[l2])) {
            l1++;
            l2++;
        }
        
        while (r1 >= 0 && shorter[r1].equals(longer[r2])) {
            r1--;
            r2--;
        }
        
        return r1 < l1;
    }
}