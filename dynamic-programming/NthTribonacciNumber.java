// https://leetcode.com/problems/n-th-tribonacci-number/ 

public class NthTribonacciNumber {
    // Dynamic programming with memoization
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        return tribRecursive(n, dp);
    }
    
    public int tribRecursive(int n, int[] dp) {
        if (n <= 2)
            return (n == 0) ? 0 : 1;
        
        if (dp[n] == 0)
            dp[n] = tribRecursive(n - 1, dp) + tribRecursive(n - 2, dp) + tribRecursive(n - 3, dp);
        
        return dp[n];
    }
}