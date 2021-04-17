// https://leetcode.com/problems/maximum-xor-for-each-query/

public class MaximumXORForEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        
        int[] prefix = new int[n];
        int[] res = new int[n];
        
        int p = 0;
        for (int i = 0; i < n; i++) {
            p ^= nums[i];
            prefix[n - i - 1] = p;
        }
        
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = maximumBit - 1; j >= 0; j--) {
                k <<= 1;
                if ((prefix[i] & (1 << j)) == 0) {
                    k |= 1;
                }
            }

            res[i] = k;
        }
        
        return res;
    }
}    
}
