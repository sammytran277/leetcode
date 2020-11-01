// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

import java.util.*;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            result = Math.max(result, points[i+1][0] - points[i][0]);
        }
        
        return result;
    }
}