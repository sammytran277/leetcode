// https://leetcode.com/problems/minimum-depth-of-binary-tree/

import java.util.*;

public class MinimumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int minDepth(TreeNode root) {        
        if (root == null) {
            return 0;
        }
        
        int currDepth = 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int N = q.size();
            for (int i = 0; i < N; i++) {
                TreeNode currNode = q.pollFirst();
                if (currNode.left == null && currNode.right == null) {
                    return currDepth + 1;
                } 
                
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            currDepth++;
        }
        
        return currDepth;
    }
}