// https://leetcode.com/problems/sum-of-all-subset-xor-totals/

public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int res = 0;
        for (int mask = 1; mask < (1 << nums.length); mask++) {
            int xorTotal = 0;
            for (int i = 0; i < 32; i++) {
                if ((mask & (1 << i)) != 0) {
                    xorTotal ^= nums[i];
                }
            }
            
            res += xorTotal;
        }
        
        return res;
    }
}
