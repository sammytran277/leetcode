// https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin 
{
    // Idea is to store points in a PriorityQueue, sorted by Euclidean distance
    public int[][] kClosest(int[][] points, int K) 
    {
        int N = points.length;
        int[][] closestPoints = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
           public int compare(int[] p1, int[] p2) 
           {
               double d1 = Math.sqrt(p1[0] * p1[0] + p1[1] * p1[1]);
               double d2 = Math.sqrt(p2[0] * p2[0] + p2[1] * p2[1]);
               if (d1 < d2) return -1;
               else if (d1 > d2) return 1;
               else return 0;
           }
        });
        
        // Add all points to the PriorityQueue
        for (int i = 0; i < N; i++)
            pq.add(points[i]);
        
        // Get the first K points with smallest Euclidean distance
        for (int i = 0; i < K; i++)
            closestPoints[i] = pq.poll();
        
        return closestPoints;
    }
}