// https://leetcode.com/problems/maximum-score-from-removing-stones/

import java.util.*;

public class MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        int[] A = new int[]{a, b, c};
        Arrays.sort(A);
        if (A[2] > A[0] + A[1]) {
            return A[0] + A[1];
        }
        
        return (a + b + c) / 2;
    }    
}
