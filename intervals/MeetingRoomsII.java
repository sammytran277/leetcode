// https://leetcode.com/problems/meeting-rooms-ii/

import java.util.*;

public class MeetingRoomsII {
    public static int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> rooms = new TreeMap<>();
        for (int[] interval : intervals) {
            rooms.put(interval[0], rooms.getOrDefault(interval[0], 0) + 1);
            rooms.put(interval[1], rooms.getOrDefault(interval[1], 0) - 1);
        }

        int result = 0;
        int roomsNeeded = 0;
        for (int numRooms : rooms.values()) {
            roomsNeeded += numRooms;
            result = Math.max(result, roomsNeeded);
        }

        return result;
    }
}
