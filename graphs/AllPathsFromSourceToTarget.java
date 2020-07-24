// https://leetcode.com/problems/all-paths-from-source-to-target/

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class AllPathsFromSourceToTarget {
    int target;
    List<List<Integer>> paths;
    HashMap<Integer, int[]> adjList;

    // Straightforward DFS with path caching
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        target = n - 1;
        paths = new ArrayList<>();
        adjList = new HashMap<>();
        
        // Trivial case
        if (n == 0)
            return paths;
        
        // Convert input to adjacency list
        for (int i = 0; i < n; i++) {
            adjList.put(i, graph[i]);
        }
        
        dfs(0, new ArrayList<Integer>());
        return paths;
    }
    
    void dfs(int currNode, List<Integer> currPath) {
        List<Integer> path = new ArrayList<>(currPath);
        path.add(currNode);
        
        // Found target, so the path should be remembered
        if (currNode == target) {
            paths.add(path);
            return;
        }
        
        // Did not find target, so recursively call dfs on neighbors
        int n = adjList.get(currNode).length;
        for (int i = 0; i < n; i++) {
            dfs(adjList.get(currNode)[i], path);
        }
    }
}