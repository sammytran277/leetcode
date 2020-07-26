// https://leetcode.com/problems/add-digits/

public class AddDigits {
    public int addDigits(int num) {
        int temp = 0;
        String s = String.valueOf(num);
        int n = s.length();
        
        if (n == 1)
            return num;
        
        for (int i = 0; i < n; i++) {
            temp += s.charAt(i) - '0';
        }

        return addDigits(temp);
    }
}