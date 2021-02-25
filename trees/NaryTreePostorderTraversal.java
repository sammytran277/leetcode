// https://leetcode.com/problems/n-ary-tree-postorder-traversal/

import java.util.*;

public class NaryTreePostorderTraversal {
    class Node {
        int val;
        List<Node> children;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        return (root == null) ? res : postorder(root, res);
    }
    
    public List<Integer> postorder(Node root, List<Integer> res) {
        for (Node child : root.children) {
            postorder(child, res);
        }
        
        res.add(root.val);
        return res;
    }
}