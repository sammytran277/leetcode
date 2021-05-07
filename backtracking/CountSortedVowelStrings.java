// https://leetcode.com/problems/count-sorted-vowel-strings/

public class CountSortedVowelStrings {
    private int res;
    private String vowels = "aoeiu";
    
    public int countVowelStrings(int n) {
        res = 0;
        backtrack(n, 0, new StringBuilder());
        return res;
    }
    
    public void backtrack(int n, int start, StringBuilder sb) {
        if (sb.length() == n) {
            res++;
        } else {
            for (int i = start; i < 5; i++) {
                sb.append(vowels.charAt(i));
                backtrack(n, i, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}