// https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/

public class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] best = new char[]{'2', '3', '0', '5', '9'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != '?') {
                sb.append(time.charAt(i));
            } else if (i == 0 && time.charAt(i + 1) != '?' && time.charAt(i + 1) - '0' > 3) {
                  sb.append('1');
            } else if (i == 1) {
                sb.append((sb.charAt(0) == '2') ? best[i] : '9');
            } else {
                sb.append(best[i]);
            }
        }
        
        return sb.toString();
    }    
}
