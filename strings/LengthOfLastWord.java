// https://leetcode.com/problems/length-of-last-word/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return (words.length == 0) ? 0 : words[words.length - 1].length();
    }    
}
