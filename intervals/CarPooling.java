// https://leetcode.com/problems/car-pooling/

import java.util.*;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> deltas = new TreeMap<>();
        for (int[] trip : trips) {
            deltas.put(trip[1], deltas.getOrDefault(trip[1], 0) + trip[0]);
            deltas.put(trip[2], deltas.getOrDefault(trip[2], 0) - trip[0]);
        }
        for (int delta : deltas.values()) {
            capacity -= delta;
            if (capacity < 0) {
                return false;
            }
        }
        
        return true;
    }
}