// https://leetcode.com/problems/interval-list-intersections/

import java.util.*;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aPtr = 0;
        int bPtr = 0;
        List<int[]> result = new ArrayList<>();
        
        while (aPtr < A.length && bPtr < B.length) {
            int low = Math.max(A[aPtr][0], B[bPtr][0]);
            int high = Math.min(A[aPtr][1], B[bPtr][1]);
            
            if (low <= high) {
                result.add(new int[]{low, high});
            }

            if (A[aPtr][1] < B[bPtr][1]) {
                aPtr++;
            } else {
                bPtr++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
