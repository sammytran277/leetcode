// https://leetcode.com/problems/happy-number/

public class HappyNumbers {
    // Use Floyd's Tortoise and Hare Algorithm
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);
        
        return slow == 1;
    }
    
    public int sumOfSquares(int n) {
        int sum = 0;
        int temp = 0;
        while (n != 0) {
            temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        
        return sum;
    }
}