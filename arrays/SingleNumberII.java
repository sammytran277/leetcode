// https://leetcode.com/problems/single-number-ii/

import java.util.HashMap;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> intFreq = new HashMap<Integer, Integer>();
        for (int num : nums)
            intFreq.put(num, intFreq.getOrDefault(num, 0) + 1);
      
        for (int key : intFreq.keySet()) {
            if (intFreq.get(key) == 1)
                return key;
        }
            
        return -1;
    }
}