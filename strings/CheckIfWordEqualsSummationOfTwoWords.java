public class CheckIfWordEqualsSummationOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return numValue(firstWord) + numValue(secondWord) == numValue(targetWord);
    }
    
    public int numValue(String s) {
        int n = 0;
        for (char c : s.toCharArray()) {
            n = (n * 10) + (c - 'a');
        }
        
        return n;
    }    
}
