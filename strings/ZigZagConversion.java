// https://leetcode.com/problems/zigzag-conversion/

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        boolean isGoingDown = false;
        int currRow = 0;
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }
            
            currRow += (isGoingDown) ? 1 : -1;
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }

        return sb.toString();
    }    
}
