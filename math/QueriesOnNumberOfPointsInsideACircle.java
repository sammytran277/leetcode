// https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

public class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points) {
                int xDiff = (point[0] - queries[i][0]);
                int yDiff = (point[1] - queries[i][1]);            
                int dist = (xDiff * xDiff) + (yDiff * yDiff);
                if (dist <= queries[i][2] * queries[i][2]) {
                    res[i]++;
                }
            }
        }
        
        return res;
    }
    
}