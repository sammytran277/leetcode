// https://leetcode.com/problems/largest-merge-of-two-strings/

public class LargestMergeOfTwoStrings {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i >= word1.length()) {
                sb.append(word2.charAt(j++));
            } else if (j >= word2.length()) {
                sb.append(word1.charAt(i++));
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i++));
            } else if (word2.charAt(j) > word1.charAt(i)) {
                sb.append(word2.charAt(j++));
            } else {
                String s = word1.substring(i, word1.length());
                String t = word2.substring(j, word2.length());
                if (s.compareTo(t) > 0) {
                    sb.append(word1.charAt(i++));
                } else {
                    sb.append(word2.charAt(j++));
                }
            }
        }
        
        return sb.toString();
    }
}