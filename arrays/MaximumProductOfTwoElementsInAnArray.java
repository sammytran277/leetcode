// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

public class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        int firstMax = 0;
        int secondMax = 0;
        
        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        
        return (firstMax - 1) * (secondMax - 1);
    }
}