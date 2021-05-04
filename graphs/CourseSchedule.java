// https://leetcode.com/problems/course-schedule/

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        int numVisited = 0;
        while (!q.isEmpty()) {
            int currCourse = q.poll();
            numVisited++;
            for (int dependent : adjList[currCourse]) {
                inDegree[dependent]--;
                if (inDegree[dependent] == 0) {
                    q.add(dependent);
                }
            }
        }
        
        return numVisited == numCourses;
    }
}
