// https://leetcode.com/problems/goat-latin/

public class GoatLatin {
    public String toGoatLatin(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = convert(i + 1, words[i]);
        }
        
        return String.join(" ", words);
    }
    
    public String convert(int wordIndex, String s) {
        StringBuilder sb = new StringBuilder();
        if (isVowel(Character.toLowerCase(s.charAt(0)))) {
            sb.append(s);
        } else {
            sb.append(s.substring(1));
            sb.append(s.charAt(0));
        }
        
        sb.append("ma");
        for (int i = 0; i < wordIndex; i++) {
            sb.append('a');
        }
        
        return sb.toString();
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}