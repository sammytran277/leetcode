// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/

public class GenerateAStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append('a');
        }

        sb.append((n % 2 != 0) ? 'a' : 'b');
        return sb.toString();
    }
}
