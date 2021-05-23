// https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.*;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }   

    public List<Integer> postorderTraversal(TreeNode root) {
        return postorder(root, new ArrayList<>());
    }
    
    public List<Integer> postorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
        
        return list;
    } 
}
