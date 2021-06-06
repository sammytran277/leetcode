// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int res = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                res = Math.max(res, count);
            } else if (c == ')') {
                count--;
            }
        }
        
        return res;
    }
}
