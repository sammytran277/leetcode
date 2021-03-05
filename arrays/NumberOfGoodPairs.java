// https://leetcode.com/problems/number-of-good-pairs/

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int[] numFreq = new int[101];
        int ans = 0;
        for (int num : nums) {
            if (numFreq[num] != 0) {
                ans += numFreq[num];
            }
            
            numFreq[num]++;
        }
        
        return ans;
    }
}