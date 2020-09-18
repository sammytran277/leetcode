// https://leetcode.com/problems/meeting-rooms/

import java.util.*;

public class MeetingRooms {
    public static boolean canAttend(int[][] A) {
        Arrays.sort(A, (X, Y) -> Integer.compare(X[0], Y[0]));
        for (int i = 0; i < A.length - 1; i++) {
            int j = i + 1;
            if (A[j][0] >= A[i][0] && A[j][0] <= A[i][1]) {
                return false;
            } 
        }
    
        return true;
    }    
}
