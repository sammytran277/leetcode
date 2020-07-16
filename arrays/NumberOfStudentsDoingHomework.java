// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/

public class NumberOfStudentsDoingHomework {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int students = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                students++;
        }
        
        return students;
    }
}