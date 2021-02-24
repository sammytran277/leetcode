// https://leetcode.com/problems/n-ary-tree-preorder-traversal/

import java.util.*;

public class NaryTreePreorderTraversal {
    class Node {
        int val;
        List<Node> children;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        return (root == null) ? res : preorder(root, res);
    }
    
    public List<Integer> preorder(Node root, List<Integer> res) {
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child, res);
        }
        
        return res;
    }
}