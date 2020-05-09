// https://leetcode.com/problems/valid-perfect-square/

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        
        for (int i = 0; i <= num / 2; i++) {
            if (i * i == num) {
                return true;
            } else if (i * i > num) {
                return false;
            }
        }
        
        return false;
    }
}