// https://leetcode.com/problems/find-the-town-judge/

public class FindTheTownJudge 
{
    public int findJudge(int N, int[][] trust) 
    {
        int[] inbound = new int[N + 1];
        int[] outbound = new int[N + 1];
        int from, to;
        
        for (int i = 0; i < trust.length; i++) 
        {
            from = trust[i][0];
            to = trust[i][1];
            inbound[to]++;
            outbound[from]++;
        }
        
        for (int i = 1; i < N + 1; i++) 
        {
            if (inbound[i] == N - 1 && outbound[i] == 0)
                return i;
        }
        
        return -1;
    }
}