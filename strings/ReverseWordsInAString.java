// https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        
        int i = 0, j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i++] = words[j];
            words[j--] = temp;
        }
        
        return String.join(" ", words);
    }
}