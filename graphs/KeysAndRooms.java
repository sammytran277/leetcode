// https://leetcode.com/problems/keys-and-rooms/

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] unlocked = new boolean[rooms.size()];
        unlocked[0] = true;
        q.add(0);
        while (!q.isEmpty()) {
            int currRoom = q.poll();
            for (int key : rooms.get(currRoom)) {
                if (!unlocked[key]) {
                    unlocked[key] = true;
                    q.add(key);
                }
            }
        }
        
        for (int i = 0; i < unlocked.length; i++) {
            if (!unlocked[i]) {
                return false;
            }
        }
        
        return true;
    }    
}
