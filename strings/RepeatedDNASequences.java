// https://leetcode.com/problems/repeated-dna-sequences/

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> seqFreq = new HashMap<>();
        int start = 0;
        for (int end = 10; end <= s.length(); end++) {
            String seq = s.substring(start, end);
            seqFreq.put(seq, seqFreq.getOrDefault(seq, 0) + 1);
            start++;
        }
        
        List<String> res = new ArrayList<>();
        for (String seq : seqFreq.keySet()) {
            if (seqFreq.get(seq) > 1) {
                res.add(seq);
            }
        }
        
        return res;
    }    
}
