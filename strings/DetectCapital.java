// https://leetcode.com/problems/detect-capital/

public class DetectCapital {
    // Count capital letters in word and check for each case
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int capitals = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                capitals++;
        }
        
        if (capitals == n || capitals == 0)
            return true;
        else if ((capitals == 1 && Character.isUpperCase(word.charAt(0))))
            return true;
        else
            return false;
    }
}