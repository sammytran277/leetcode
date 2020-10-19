// https://leetcode.com/problems/coordinate-with-maximum-network-quality/

import java.util.*;

public class CoordinateWithMaximumNetworkQuality {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] result = new int[towers.length];
        for (int i = 0 ; i < towers.length; i++) {
            for (int j = 0; j < towers.length; j++) {
                if (i == j) {
                    result[i] += towers[i][2];
                    continue;
                }
                
                int x1 = towers[i][0];
                int y1 = towers[i][1];
                int x2 = towers[j][0];
                int y2 = towers[j][1];
                
                double distance = getDistance(x1, y1, x2, y2);
                if (distance <= radius) {
                    result[i] += Math.floor(towers[j][2] / (1 + distance));  
                }
            }
        }
        
        int maxResult = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > maxResult) {
                maxResult = result[i];
            }
        }
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (
            towers[a][0] == towers[b][0]) ? 
            Integer.compare(towers[a][1], towers[b][1]) : 
            Integer.compare(towers[a][0], towers[b][0])
        );
        
        for (int i = 0; i < result.length; i++) {
            if (result[i] == maxResult) {
                pq.add(i);
            }
        }
        
        return new int[]{towers[pq.peek()][0], towers[pq.peek()][1]};
    }
    
    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1)  + (y2 - y1) * (y2 - y1));
    }
}