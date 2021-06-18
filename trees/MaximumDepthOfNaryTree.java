// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

import java.util.*;

public class MaximumDepthOfNaryTree {
    public class Node {
        int val;
        List<Node> children;        
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        return maxDepth(root, 1);
    }
    
    public int maxDepth(Node root, int depth) {
        if (root.children.size() == 0) {
            return depth;
        }
        
        int max = depth;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child, depth + 1));
        }
        
        return max;
    } 
}
