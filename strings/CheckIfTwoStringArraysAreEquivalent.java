// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

public class CheckIfTwoStringArraysAreEquivalent {
    private class CharIterator {
        private String[] words;
        private int wordIndex;
        private int charIndex;
        
        public CharIterator(String[] words) {
            this.words = words;
            wordIndex = 0;
            charIndex = 0;
        }
        
        public boolean hasNext() {
            return wordIndex != words.length;
        }
        
        public char next() {
            String word = words[wordIndex]; 
            char next = word.charAt(charIndex++);
            if (charIndex == word.length()) {
                wordIndex++;
                charIndex = 0;
            }
            
            return next;
        }
    }
    
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        CharIterator charIterator1 = new CharIterator(word1);
        CharIterator charIterator2 = new CharIterator(word2);
        while (charIterator1.hasNext() && charIterator2.hasNext()) {
            if (charIterator1.next() != charIterator2.next()) {
                return false;
            }
        }
        
        return !charIterator1.hasNext() && !charIterator2.hasNext();
    }    
}