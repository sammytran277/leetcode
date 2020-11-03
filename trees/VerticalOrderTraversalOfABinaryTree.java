// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Pair {
        int first;
        int second;
        
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    Map<Integer, List<Pair>> posToPairs;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        posToPairs = new TreeMap<>();
        dfs(root, 0, 0);
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Go through each position in order (e.g. -2, -1, 0, 1, 2, ...)
        for (int pos : posToPairs.keySet()) {
            List<Pair> pairs = posToPairs.get(pos);
            // Sort values based on level, then by value
            Collections.sort(pairs, (a, b) -> {
                if (a.first != b.first) {
                    return Integer.compare(a.first, b.first);
                }
                
                return Integer.compare(a.second, b.second);
            });
            
            // Create vertical order traversal list 
            List<Integer> vertical = new ArrayList<>();
            for (Pair p : pairs) {
                vertical.add(p.second);
            }
            
            result.add(vertical);
        }
        
        return result;
    }
    
    public void dfs(TreeNode root, int level, int pos) {
        if (root == null) {
            return;
        }
        
        if (!posToPairs.containsKey(pos)) {
            posToPairs.put(pos, new ArrayList<>());
        }
        
        // Pairs are of the form [nodeLevel, nodeValue]
        posToPairs.get(pos).add(new Pair(level, root.val));
        dfs(root.left, level + 1, pos - 1);
        dfs(root.right, level + 1, pos + 1);
    }
}