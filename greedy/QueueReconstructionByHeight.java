// https://leetcode.com/problems/queue-reconstruction-by-height/

import java.util.Arrays;
import java.util.ArrayList;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); 
        ArrayList<int[]> reconstructedQueue = new ArrayList<int[]>();
        
        for (int i = 0; i < people.length; i++) {
            reconstructedQueue.add(people[i][1], people[i]);
        }
        
        return reconstructedQueue.toArray(people);
    }
}