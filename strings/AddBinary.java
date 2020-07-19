// https://leetcode.com/problems/add-binary/

import java.util.Stack;

public class AddBinary {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        int carry = 0;
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < Math.max(n, m); i++) {
            int sum = carry;
            sum += (n-i-1 >= 0) ? Character.getNumericValue(a.charAt(n-i-1)) : 0;
            sum += (m-i-1 >= 0) ? Character.getNumericValue(b.charAt(m-i-1)) : 0;
            
            if (sum < 2) {
                s.push((char) (sum + '0'));
                carry = 0;
            } else {
                s.push((char) (sum % 2 + '0'));
                carry = 1;
            }
        }
        
        if (carry == 1) {
            s.push((char) (carry + '0'));
        }
        
        StringBuilder result = new StringBuilder();
        while (!s.empty()) {
            result.append(s.pop());
        }
        
        return result.toString();
    }
}