// https://leetcode.com/problems/insert-interval/

import java.util.*;

class InsertIntervals {
    // Same approach as Merge Intervals
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalsList.add(interval);
        }
        
        intervalsList.add(newInterval);
        Collections.sort(intervalsList, (A, B) -> Integer.compare(A[0], B[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] currInterval = intervalsList.get(0);
        result.add(currInterval);
        
        for (int[] interval : intervalsList) {
            if (interval[0] <= currInterval[1]) {
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            } else {
                result.add(interval);
                currInterval = interval;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}