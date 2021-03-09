// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    ans[i]++;
                }
            }
        }
        
        return ans;
    }
}