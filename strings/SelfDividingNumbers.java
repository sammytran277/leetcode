// https://leetcode.com/problems/self-dividing-numbers/

import java.util.*;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    public boolean isSelfDividing(int n) {
        List<Integer> digits = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            if (temp % 10 == 0) {
                return false;
            }
            
            digits.add(temp % 10);
            temp /= 10;
        }
        
        for (int digit : digits) {
            if (n % digit != 0) {
                return false;
            }
        }
        
        return true;
    }    
}
