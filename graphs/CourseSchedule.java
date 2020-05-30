// https://leetcode.com/problems/course-schedule/

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseSchedule 
{
    // Standard topological sort implementation, look for existence of cycles
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        LinkedList<Integer> toVisit = new LinkedList<Integer>();
        
        // Initialize adjacency list and in-degree mapping
        for (int i = 0; i < numCourses; i++) 
        {
            adjList.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }
        
        // Represent graph as adjacency list and map each course to number of prerequisites
        for (int[] prereq : prerequisites) 
        {
            adjList.get(prereq[1]).add(prereq[0]);
            inDegree.put(prereq[0], inDegree.get(prereq[0]) + 1);
        }

        // Add all courses with in-degree = 0 to queue
        for (int course : adjList.keySet()) 
        {
            if (inDegree.get(course) == 0)
                toVisit.add(course);
        }
        
        // If there are no courses with in-degree = 0, there must be a cycle
        if (toVisit.size() == 0)
            return false;
        
        int coursesTaken = 0;
        while (toVisit.size() != 0) 
        {
            int currCourse = toVisit.removeFirst();
            coursesTaken++;
            
            // Decrement the in-degree of all neighboring courses
            for (int neighbor : adjList.get(currCourse)) 
            {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0)
                    toVisit.add(neighbor);
            }
        }
        
        return (coursesTaken == numCourses) ? true : false;
    }
}