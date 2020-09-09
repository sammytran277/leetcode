// https://leetcode.com/problems/merge-intervals/

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int N = intervals.length;
        if (N <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (A, B) -> Integer.compare(A[0], B[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}