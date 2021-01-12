// https://leetcode.com/problems/maximum-units-on-a-truck/

import java.util.*;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));
        int i = 0;
        int numUnits = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            if (truckSize >= boxTypes[i][0]) {
                numUnits += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                numUnits += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
            
            i++;
        }
        
        return numUnits;
    }
}