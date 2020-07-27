// https://leetcode.com/problems/all-paths-from-source-to-target/

import java.util.List;
import java.util.ArrayList;

public class AllPathsFromSourceToTarget {
    int target;
    List<List<Integer>> paths;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        target = n - 1;
        paths = new ArrayList<>();
   
        // Trivial case
        if (n == 0)
            return paths;

        dfs(0, new ArrayList<Integer>(), graph);
        return paths;
    }
    
    void dfs(int currNode, List<Integer> currPath, int[][] graph) {
        List<Integer> path = new ArrayList<>(currPath);
        path.add(currNode);
        
        // Found target, so the path should be remembered
        if (currNode == target) {
            paths.add(path);
            return;
        }
        
        // Did not find target, so recursively call dfs on neighbors
        int n = graph[currNode].length;
        for (int i = 0; i < n; i++) {
            dfs(graph[currNode][i], path, graph);
        }
    }
}