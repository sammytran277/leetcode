// https://leetcode.com/problems/consecutive-characters/

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int maxPower = 0;
        char c = s.charAt(0);
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(end) != c) {
                c = s.charAt(end);
                start = end;
            }
            
            maxPower = Math.max(maxPower, end - start + 1);
        }
        
        return maxPower;
    }
}
