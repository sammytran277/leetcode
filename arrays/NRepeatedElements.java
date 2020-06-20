// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

import java.util.HashMap;

public class NRepeatedElements {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> intFreq = new HashMap<Integer, Integer>();
        for (int n : A)
            intFreq.put(n, intFreq.getOrDefault(n, 0) + 1);
        
        for (int key : intFreq.keySet()) {
            if (intFreq.get(key) == A.length / 2)
                return key;
        }
        
        return -1;
    }
}