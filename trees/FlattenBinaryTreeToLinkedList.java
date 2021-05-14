// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

import java.util.*;

public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private List<TreeNode> preorder;
    
    public void flatten(TreeNode root) {
        preorder = new ArrayList<>();
        preorder(root);
        preorder.add(null);
        
        int n = preorder.size();
        for (int i = 0; i < n - 1; i++) {
            preorder.get(i).left = null;
            preorder.get(i).right = preorder.get(i + 1);
        }
    }
    
    public void preorder(TreeNode root) {
        if (root != null) {
            preorder.add(root);
            preorder(root.left);
            preorder(root.right);
        }
    }    
}
