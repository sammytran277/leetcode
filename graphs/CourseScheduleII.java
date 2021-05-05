// https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            adjList[prereq[1]].add(prereq[0]);
            inDegree[prereq[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> courseOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int currCourse = q.poll();
            courseOrder.add(currCourse);
            for (int dependent : adjList[currCourse]) {
                inDegree[dependent]--;
                if (inDegree[dependent] == 0) {
                    q.add(dependent);
                }
            }
        }
        
        if (courseOrder.size() != numCourses) {
            return new int[]{};
        }
        
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = courseOrder.get(i);
        }
        
        return res;
    }
}