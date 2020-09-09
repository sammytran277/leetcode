// https://leetcode.com/problems/circular-array-loop/

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = i;
            int len = 0;
            int dx = A[i];

            while (len == 0 || slow != fast) {
                if (sign(A[slow]) != sign(dx) || sign(A[fast]) != sign(dx)) {
                    break;
                }
                
                if (dx > 0) {
                    slow = (slow + A[slow]) % n;
                    fast = (fast + A[fast]) % n;
                    fast = (fast + A[fast]) % n;
                } else {
                    slow = (slow + n - (0 - A[slow]) % n) % n;
                    fast = (fast + n - (0 - A[fast]) % n) % n;
                    fast = (fast + n - (0 - A[fast]) % n) % n;
                }

                len++;
            }
            
            if (slow == i && len > 1) {
                return true;
            }
        }
        
        return false;
    }
    
    public int sign(int n) {
        return (n > 0) ? 0 : 1;
    }
}