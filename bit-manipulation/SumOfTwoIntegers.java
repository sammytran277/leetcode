// https://leetcode.com/problems/sum-of-two-integers/

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b; // add without carrying
            int carry = (a & b) << 1; // carry, but don't add
            a = sum;
            b = carry;
        }
        
        return a;
    }
}
