// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

import java.util.*;

public class SortIntegersByTheNumberOfOneBits {
    private class BitComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            Integer aBitCount = Integer.bitCount(a);
            Integer bBitCount = Integer.bitCount(b);
            
            if (aBitCount != bBitCount) {
                return aBitCount.compareTo(bBitCount); 
            }
            
            return a.compareTo(b);
        }
    } 
    
    public int[] sortByBits(int[] nums) {
        List<Integer> A = new ArrayList<>();
        for (int num : nums) {
            A.add(num);
        }
        
        Collections.sort(A, new BitComparator());
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = A.get(i);
        }
        
        return res;
    }
}