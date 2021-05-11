// https://leetcode.com/problems/count-and-say/

public class CountAndSay {
    public String countAndSay(int n) {
        String[] wayToSay = new String[n + 1];
        wayToSay[1] = "1";
        for (int i = 2; i <= n; i++) {
            wayToSay[i] = say(wayToSay[i - 1]);
        }
        
        return wayToSay[n];
    }
    
    public String say(String s) {
        StringBuilder sb = new StringBuilder();
        for (int start = 0, end = 0; end <= s.length(); end++) {
            if (end == s.length() || s.charAt(start) != s.charAt(end)) {
                sb.append(String.valueOf(end - start) + s.charAt(start));
                start = end;
            }
        }
        
        return sb.toString();
    }
}
