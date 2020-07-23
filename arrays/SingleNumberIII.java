// https://leetcode.com/problems/single-number-iii/

import java.util.HashMap;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        
        int i = 0;
        int[] uniques = new int[2];
        for (int key : numFreq.keySet()) {
            if (numFreq.get(key) == 1) {
                uniques[i++] = key;
            }
        }
        
        return uniques;
    }
}