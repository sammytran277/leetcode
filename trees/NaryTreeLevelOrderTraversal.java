// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    class Node {
        int val;
        List<Node> children;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node currNode = q.poll();
                level.add(currNode.val);
                for (Node child : currNode.children) {
                    q.add(child);
                }
            }
            
            levels.add(level);
        }
        
        return levels;
    }
}