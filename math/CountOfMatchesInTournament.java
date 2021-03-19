// https://leetcode.com/problems/count-of-matches-in-tournament/

public class CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            res += n / 2;
            n -= n / 2;
        }
        
        return res;
    }
}