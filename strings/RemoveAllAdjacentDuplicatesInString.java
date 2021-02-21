// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        boolean containsDuplicates = true;
        while (containsDuplicates) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    break;
                }
            }
            
            containsDuplicates = s.length() != sb.length();
            s = sb.toString();
        }
        
        return s;
    }
}