// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] charFreq = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charFreq[chars.charAt(i) - 'a']++;
        }
        
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            int[] wordCharFreq = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                wordCharFreq[words[i].charAt(j) - 'a']++;
            }
            
            boolean canBeFormed = true;
            for (int j = 0; j < charFreq.length; j++) {
                if (charFreq[j] < wordCharFreq[j]) {
                    canBeFormed = false;
                    break;
                }
            }
            
            if (canBeFormed) {
                count += words[i].length();
            }
        }
        
        return count;
    }    
}
