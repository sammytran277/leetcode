// https://leetcode.com/problems/sorting-the-sentence/

public class SortingTheSentence {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] res = new String[words.length];
        for (String word : words) {
            int wordPosition = word.charAt(word.length() - 1) - '1'; 
            res[wordPosition] = word.substring(0, word.length() - 1);
        }
        
        return String.join(" ", res);
    }    
}
