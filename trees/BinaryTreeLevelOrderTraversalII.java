// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() != 0) {
            int N = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                TreeNode currNode = q.pollFirst();
                level.add(currNode.val);
                
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            levels.add(0, level);
        }

        return levels;
    }
}