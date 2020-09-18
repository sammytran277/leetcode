// https://leetcode.com/problems/corporate-flight-bookings/

import java.util.*;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Map<Integer, Integer> seatsReq = new TreeMap<>();
        for (int[] booking : bookings) {
            seatsReq.put(booking[0] - 1, seatsReq.getOrDefault(booking[0] - 1, 0) + booking[2]);
            seatsReq.put(booking[1], seatsReq.getOrDefault(booking[1], 0) - booking[2]);
        }
        
        int seats = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (seatsReq.containsKey(i)) {
                seats += seatsReq.get(i);
            }
            
            ans[i] = seats;
        }
        
        return ans;
    }
}