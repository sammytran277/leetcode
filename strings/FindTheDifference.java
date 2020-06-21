// https://leetcode.com/problems/find-the-difference/

public class FindTheDifference  {
    public char findTheDifference(String s, String t) {
        int n = s.length(), m = t.length();
        int[] charFreq = new int[26];
        for (int i = 0; i < n; i++)
            charFreq[s.charAt(i) - 'a'] += 1;
        
        for (int i = 0; i < m; i++)
            charFreq[t.charAt(i) - 'a'] -= 1;

        for (int i = 0; i < 26; i++) {
            if (charFreq[i] < 0)
                return (char) ('a' + i);
        }
        
        return 'a';
    }
}