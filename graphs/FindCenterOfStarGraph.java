// https://leetcode.com/problems/find-center-of-star-graph/

public class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];
        for (int[] edge : edges) {
            for (int node : edge) {
                degree[node]++;
                if (degree[node] == n - 1) {
                    return node;
                }
            }
        }

        return -1;
    }    
}
