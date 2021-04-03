// https://leetcode.com/problems/count-nice-pairs-in-an-array/

import java.util.*;

public class CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> diffFreq = new HashMap<>();
        
        int res = 0;
        for (int num : nums) {
            int diff = num - rev(num);
            diffFreq.put(diff, diffFreq.getOrDefault(diff, 0) + 1);
            res = (res + diffFreq.get(diff) - 1) % mod;
        }
        
        return res;
    }
    
    public int rev(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        
        return rev;
    }
}