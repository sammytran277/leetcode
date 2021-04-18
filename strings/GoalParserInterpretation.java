// https://leetcode.com/problems/goal-parser-interpretation/

public class GoalParserInterpretation {
    public String interpret(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
            } else {
                sb.append("al");
                i += 4;
            }
        }
        
        return sb.toString();
    }    
}
